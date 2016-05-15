package com.github.creepid.el.example.expression;

/**
 * Created by nightingale on 14.05.16.
 *
 * Expression to evaluate
 */
public interface Expression<V> {

    /**
     * Returns evaluation result
     * @return evaluation result
     */
    public V getEvaluationResult();

}
