package com.pokejob.utils;

import lombok.experimental.UtilityClass;

import java.util.function.Consumer;

@UtilityClass
public class DoIfNotNull {
    public static <T> void doIfNotNull(final Consumer<T> consumer, final T obj) {
        if (obj != null) {
            consumer.accept(obj);
        }
    }
}
