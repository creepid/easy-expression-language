package com.github.creepid.el.example;

import com.github.creepid.el.example.expression.Expression;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nightingale on 14.05.16.
 *
 * Simple external context implementation
 */
public class SimpleExternalContext implements  ExternalContext{

    private Map<String, Object> parameters = new HashMap<String, Object>();

    @Override
    public Object getParameter(String parameterName) {
        return parameters.get(parameterName);
    }

    public void addParameter(String name, Object value){
        parameters.put(name, value);
    }
}
