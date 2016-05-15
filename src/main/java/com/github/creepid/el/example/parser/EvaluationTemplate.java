package com.github.creepid.el.example.parser;

/**
 * Created by nightingale on 14.05.16.
 *
 * Template that allows to define calculation expression area
 */
public interface EvaluationTemplate {

    /**
     * @return  evaluation start string
     */
    public String getEvaluationStart();


    /**
     * @return  evaluation finish string
     */
    public String getEvaluationEnd();

}
