package com.github.creepid.el.example;

import com.github.creepid.el.example.expression.Expression;

/**
 * Created by nightingale on 14.05.16.
 *
 * Context for working with expressions
 */
public interface EvaluationContext {

    /**
     * Evaluate result of expression
     * @param expression - expression to eval
     * @return calculation result
     */
    public Object getEvaluationResult(Expression expression);

    /**
     * Add evaluation result of expression to context,
     * without the need to compute it in the future
     * @param expression - expression object to add
     * @param result - corresponding evaluation result
     */
    public void addEvaluationResult(Expression expression, Object result);
}
