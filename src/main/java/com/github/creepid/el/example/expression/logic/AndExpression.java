package com.github.creepid.el.example.expression.logic;

import com.github.creepid.el.example.EvaluationContext;

/**
 * Created by nightingale on 14.05.16.
 */
public class AndExpression extends CompoundExpression {

    public AndExpression(EvaluationContext context) {
        super(context);
    }

    @Override
    public void interpret(EvaluationContext context){
        exprOne.interpret(context);
        exprAnother.interpret(context);

        boolean oneResult = (Boolean) context.getEvaluationResult(exprOne);
        boolean anotherResult = (Boolean) context.getEvaluationResult(exprAnother);
        context.addEvaluationResult(this, oneResult && anotherResult);
    }
}
