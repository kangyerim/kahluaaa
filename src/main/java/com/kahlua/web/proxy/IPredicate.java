package com.kahlua.web.proxy;

@FunctionalInterface
public interface IPredicate<T> {
    public boolean test(T t);
}
