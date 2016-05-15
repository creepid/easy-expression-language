package com.github.creepid.el.example.expression.logic;

import com.github.creepid.el.example.EvaluationContext;

/**
 * Created by nightingale on 14.05.16.
 */
public class OrExpression extends CompoundExpression {

    public OrExpression(EvaluationContext context) {
        super(context);
    }

    @Override
    public void interpret(EvaluationContext context){
        exprOne.interpret(context);
        exprAnother.interpret(context);

        boolean oneResult = (Boolean) context.getEvaluationResult(exprOne);
        boolean anotherResult = (Boolean) context.getEvaluationResult(exprOne);
        context.addEvaluationResult(this, oneResult || anotherResult);
    }
}
