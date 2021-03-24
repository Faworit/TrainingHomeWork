package com.epam.freshnewsrest.util;

@FunctionalInterface
public interface DTOtoEntity<T, F> {
    F convert(T from);
}