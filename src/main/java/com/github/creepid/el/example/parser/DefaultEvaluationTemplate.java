package com.github.creepid.el.example.parser;

/**
 * Created by nightingale on 14.05.16.
 */
public class DefaultEvaluationTemplate implements  EvaluationTemplate{

    @Override
    public String getEvaluationStart() {
        return "$${";
    }

    @Override
    public String getEvaluationEnd() {
        return "}";
    }
}
