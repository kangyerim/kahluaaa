package com.kahlua.web.proxy;

@FunctionalInterface
public interface IConsumer<T> {
    public void accept(T t);
}
