package com.github.creepid.el.example.expression;

import com.github.creepid.el.example.EvaluationContext;

/**
 * Created by nightingale on 14.05.16.
 *
 * Base evaluation expression
 */
public abstract class AbstractExpression implements Expression{

    protected final EvaluationContext context;

    public AbstractExpression(EvaluationContext context) {
        this.context = context;
    }

    /**
     * According to interpreter pattern,
     * this method has to be implemented to add evaluation result to context
     * @param context - context to work with
     */
    public abstract void interpret(EvaluationContext context);

    @Override
    public Object getEvaluationResult(){
        interpret(context);
        return context.getEvaluationResult(this);
    }

}
