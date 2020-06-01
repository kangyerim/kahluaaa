package com.kahlua.web.proxy;

@FunctionalInterface
public interface ISupplier<T> {
    public T get();
}
