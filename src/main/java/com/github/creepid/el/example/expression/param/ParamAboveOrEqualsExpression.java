package com.github.creepid.el.example.expression.param;

import com.github.creepid.el.example.EvaluationContext;

/**
 * Created by nightingale on 14.05.16.
 */
public class ParamAboveOrEqualsExpression extends ParamComparableExpression<Double, Double> {

    public ParamAboveOrEqualsExpression(EvaluationContext context) {
        super(context);
    }

    @Override
    public void interpret(EvaluationContext context){
        Double param = getParameter();
        Double valueToCompare = getValueToCompare();
        boolean result = (Double.compare(param , valueToCompare) >= 0);
        context.addEvaluationResult(this, result);
    }

}
