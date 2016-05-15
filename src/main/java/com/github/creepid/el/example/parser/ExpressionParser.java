package com.github.creepid.el.example.parser;

import com.github.creepid.el.example.expression.Expression;

/**
 * Created by nightingale on 14.05.16.
 *
 * Allows to get expression from string
 */
public interface ExpressionParser {

    /**
     * Parsing the expression from a string
     * @param expression string to parse
     * @return {@link com.github.creepid.el.example.expression.Expression}
     */
    public Expression parse(String expression);

}
