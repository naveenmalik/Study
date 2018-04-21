package com.nav.features;

/**
 * Created by Neo on 6/25/2017.
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert (F from);
}
