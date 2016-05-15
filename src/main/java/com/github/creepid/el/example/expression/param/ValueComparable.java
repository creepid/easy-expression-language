package com.github.creepid.el.example.expression.param;

/**
 * Created by nightingale on 14.05.16.
 *
 * Allows to be compared with another value
 */
public interface ValueComparable<V> {

    /**
     * Set value to compare with
     * @param value
     */
    public void setValueToCompare(V value);

}
