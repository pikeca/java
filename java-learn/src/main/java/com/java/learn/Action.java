package com.java.learn;

/**
 * @author 二雷
 * @date 2018/11/15
 */
@FunctionalInterface
public interface Action<T> {

    void print(T t);
}
