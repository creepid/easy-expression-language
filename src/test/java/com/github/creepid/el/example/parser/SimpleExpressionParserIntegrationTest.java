package com.github.creepid.el.example.parser;

import com.github.creepid.el.example.ExternalContext;
import com.github.creepid.el.example.SimpleExternalContext;
import com.github.creepid.el.example.expression.Expression;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleExpressionParserIntegrationTest {

    private SimpleExternalContext externalContext = new SimpleExternalContext();

    @Before
    public void setUp(){
        externalContext.addParameter("a", 3d);
        externalContext.addParameter("b", 2.50d);
        externalContext.addParameter("c", -4.00d);
    }

    @Test
    public void testParse() throws Exception {
        String expressionToParse1 = "$${((a<14.0) or (b>2.43)) and (c==-4.00)}";
        ExpressionParser parser1 = new SimpleExpressionParser(externalContext);
        Expression<Boolean> expression1 = parser1.parse(expressionToParse1);
        assertTrue(expression1.getEvaluationResult());

        String expressionToParse2 = "$${(a>67.0) or (b<1.2)}";
        ExpressionParser parser2 = new SimpleExpressionParser(externalContext);
        Expression<Boolean> expression2 = parser2.parse(expressionToParse2);
        assertFalse(expression2.getEvaluationResult());
    }
}