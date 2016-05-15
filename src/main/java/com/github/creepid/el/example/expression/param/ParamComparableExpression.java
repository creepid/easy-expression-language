package com.github.creepid.el.example.expression.param;

import com.github.creepid.el.example.EvaluationContext;
import com.github.creepid.el.example.expression.AbstractExpression;

/**
 * Created by nightingale on 14.05.16.
 */
abstract class ParamComparableExpression<V, P> extends AbstractExpression implements ValueComparable<V>, ParametrableExpression<P>  {

    protected V valueToCompare;
    protected P parameter;

    public ParamComparableExpression(EvaluationContext context) {
        super(context);
    }

    @Override
    public void setValueToCompare(V valueToCompare) {
        this.valueToCompare = valueToCompare;
    }

    public V getValueToCompare() {
        return valueToCompare;
    }

    public P getParameter(){
        return parameter;
    }

    public void setParameter(P parameter){
        this.parameter = parameter;
    }
}
