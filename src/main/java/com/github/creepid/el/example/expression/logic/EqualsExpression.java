package com.github.creepid.el.example.expression.logic;

import com.github.creepid.el.example.EvaluationContext;

/**
 * Created by nightingale on 14.05.16.
 */
public class EqualsExpression extends CompoundExpression {

    public EqualsExpression(EvaluationContext context) {
        super(context);
    }

    @Override
    public void interpret(EvaluationContext context){
        exprOne.interpret(context);
        exprAnother.interpret(context);

        Boolean oneResult = (Boolean) context.getEvaluationResult(exprOne);
        Boolean anotherResult = (Boolean) context.getEvaluationResult(exprOne);
        context.addEvaluationResult(this, oneResult.equals(anotherResult));
    }
}
