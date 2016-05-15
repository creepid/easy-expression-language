package com.github.creepid.el.example.parser;

import com.github.creepid.el.example.EvaluationContext;
import com.github.creepid.el.example.ExternalContext;
import com.github.creepid.el.example.SimpleEvaluationContext;
import com.github.creepid.el.example.expression.Expression;
import com.github.creepid.el.example.expression.logic.AndExpression;
import com.github.creepid.el.example.expression.logic.ExpressionAware;
import com.github.creepid.el.example.expression.logic.OrExpression;
import com.github.creepid.el.example.expression.param.*;

import java.util.*;

/**
 * Created by nightingale on 14.05.16.
 *
 * Simple expression parser implementation
 */
public class SimpleExpressionParser implements ExpressionParser{

    private EvaluationTemplate evaluationTemplate = new DefaultEvaluationTemplate();
    private final EvaluationContext evaluationContext = new SimpleEvaluationContext();
    //context where to get parameters for expressions
    private final ExternalContext externalContext;
    //stack of expression's values
    private Deque<Object> vals = new ArrayDeque<Object>();
    //stack of expression's parameters
    private Deque<Object> params = new ArrayDeque<Object>();
    //stack of transitional expressions (without corresponding values for the evaluation)
    private Deque<Expression> transExpr = new ArrayDeque<Expression>();
    //stack of expressions with given values for the evaluation
    private Deque<Expression> internalExpr = new ArrayDeque<Expression>();
    //pre-processors list
    private List<ExpressionPreProcessor> preProcessors = new LinkedList<ExpressionPreProcessor>();


    public SimpleExpressionParser(ExternalContext externalContext) {
        this.externalContext = externalContext;
        preProcessors.add(new ExpressionEntitySeparator());
    }

    private void eval() {
        Expression lastExpression = transExpr.pop();

        //is given expression ValueComparable?
        if (lastExpression instanceof ValueComparable) {
            ValueComparable valueComparable = (ValueComparable) lastExpression;
            //set value
            valueComparable.setValueToCompare(vals.pop());
        }

        //is given expression ExpressionAware?
        if (lastExpression instanceof ExpressionAware) {
            ExpressionAware expressionAware = (ExpressionAware) lastExpression;
            expressionAware.setExprOne(internalExpr.pop());
            expressionAware.setExprAnother(internalExpr.pop());
        }

        //is given expression ParametrableExpression
        if (lastExpression instanceof ParametrableExpression){
            ParametrableExpression parametrableExpression = (ParametrableExpression) lastExpression;
            //set parameter
            parametrableExpression.setParameter(params.pop());
        }

        internalExpr.push(lastExpression);
    }

    /**
     * Processing expression's entity
     * @param entity - given entity (parameter, value, operator etc.)
     */
    private void processEntity(String entity) {
        Object parameter = externalContext.getParameter(entity);
        if (parameter != null) {
            params.add(parameter);
        }else{
            vals.add(Double.valueOf(entity));
        }
    }

    @Override
    public Expression parse(String expression) {
        String expressionProcessed = expression;
        //pre-process the expression
        for (ExpressionPreProcessor preProcessor : preProcessors) {
            expressionProcessed = preProcessor.preProcess(expressionProcessed);
        }

        //tokenize the expression
        StringTokenizer tokenizer = new StringTokenizer(expressionProcessed, ExpressionEntities.DELIMITER);
        while (tokenizer.hasMoreElements()) {
            String element = tokenizer.nextToken();

            //is evaluation started?
            if (element.equals(evaluationTemplate.getEvaluationStart())) {
                continue;
            }

            //is evaluation finished?
            if (element.equals(evaluationTemplate.getEvaluationEnd())) {
                eval();
                continue;
            }

            //define evaluation element
            switch (element) {
                case "(":
                    break;
                case "and":
                case "AND":
                    transExpr.push(new AndExpression(evaluationContext));
                    break;
                case "or":
                case "OR":
                    transExpr.push(new OrExpression(evaluationContext));
                    break;
                case ">":
                case "above":
                case "gt":
                case "ABOVE": {
                    transExpr.push(new ParamAboveExpression(evaluationContext));
                    break;
                }
                case ">=": {
                    transExpr.push(new ParamAboveOrEqualsExpression(evaluationContext));
                    break;
                }
                case "<":
                case "lt":
                case "less":
                case "LESS":
                case "below":
                case "BELOW": {
                    transExpr.push(new ParamBelowExpression(evaluationContext));
                    break;
                }
                case "<=": {
                    transExpr.push(new ParamBelowOrEqualsExpression(evaluationContext));
                    break;
                }
                case "==":
                case "equals":
                case "EQUALS": {
                    transExpr.push(new ParamEqualsExpression(evaluationContext));
                    break;
                }
                case ")":
                    //evaluate expression
                    eval();
                    break;
                default:
                    //process entity
                    processEntity(element);
            }

        }

        //return result expression
        return internalExpr.pop();
    }

}
