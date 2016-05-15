package com.github.creepid.el.example.parser;

/**
 * Created by nightingale on 14.05.16.
 *
 * Pre-processor, needed for entity separation using delimiter
 */
public class ExpressionEntitySeparator implements ExpressionPreProcessor{

    private static final String DELIM = ExpressionEntities.DELIMITER;
    private static final String[] toSeparate = {"(", ")", ">=", "<=", ">", "<", "=="};

    private void seclude(StringBuilder exprBuilder, String occur) {
        int index = exprBuilder.indexOf(occur);
        int offset = 0;

        while (index >= 0) {
            offset = index;

            if (offset - 1 > 0) {
                exprBuilder = exprBuilder.insert(index, DELIM);
            }

            exprBuilder.insert(index + occur.length() + 1, DELIM);
            index = exprBuilder.indexOf(occur, index + 2 * DELIM.length() + 1);
        }

    }

    @Override
    public String preProcess(String expression) {
        StringBuilder exprBuilder = new StringBuilder(expression);

        for (int i = 0; i < toSeparate.length; i++) {
            String token = toSeparate[i];
            seclude(exprBuilder, token);
        }

        return exprBuilder.toString();
    }
}
