package com.github.creepid.el.example;

import com.github.creepid.el.example.expression.Expression;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nightingale on 14.05.16.
 *
 * Simple evaluation context implementation
 */
public class SimpleEvaluationContext implements EvaluationContext {

    private Map<Expression, Object> evaluationResults = new HashMap<Expression, Object>();

    @Override
    public Object getEvaluationResult(Expression expression) {
        return evaluationResults.get(expression);
    }

    @Override
    public void addEvaluationResult(Expression expression, Object value) {
        evaluationResults.put(expression, value);
    }
}
