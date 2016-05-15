package com.github.creepid.el.example.expression.param;

/**
 * Created by nightingale on 14.05.16.
 *
 * Allows to associate a parameter with an expression
 */
public interface ParametrableExpression<P> {

    /**
     * To set parameter
     * @param value - parameter value
     */
    public void setParameter(P value);

}
