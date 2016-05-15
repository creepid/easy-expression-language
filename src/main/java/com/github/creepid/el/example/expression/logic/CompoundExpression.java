package com.github.creepid.el.example.expression.logic;

import com.github.creepid.el.example.EvaluationContext;
import com.github.creepid.el.example.expression.AbstractExpression;
import com.github.creepid.el.example.expression.Expression;

/**
 * Created by nightingale on 14.05.16.
 */
abstract class CompoundExpression extends AbstractExpression implements ExpressionAware {

    protected AbstractExpression exprOne;
    protected AbstractExpression exprAnother;

    public CompoundExpression(EvaluationContext context) {
        super(context);
    }

    public Expression getExprOne() {
        return exprOne;
    }

    @Override
    public void setExprOne(Expression exprOne) {
        this.exprOne = (AbstractExpression) exprOne;
    }

    public Expression getExprAnother() {
        return exprAnother;
    }

    @Override
    public void setExprAnother(Expression exprAnother) {
        this.exprAnother = (AbstractExpression) exprAnother;
    }

}
