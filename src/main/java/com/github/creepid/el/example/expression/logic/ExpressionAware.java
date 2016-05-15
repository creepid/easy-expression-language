package com.github.creepid.el.example.expression.logic;

import com.github.creepid.el.example.expression.Expression;

/**
 * Created by nightingale on 14.05.16.
 *
 * Expression for working with other expressions
 */
public interface ExpressionAware {

    public void setExprOne(Expression exprOne);

    public void setExprAnother(Expression exprAnother);

}
