package com.github.creepid.el.example;

/**
 * Created by nightingale on 14.05.16.
 *
 * External context, where to get parameters
 */
public interface ExternalContext<P> {

    /**
     * Getting parameter value
     * @param parameterName - parameter name
     * @return parameter value
     */
    public P getParameter(String parameterName);

}
