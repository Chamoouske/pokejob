package com.pokejob.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class DoIfNotNullTest {

    @Nested
    @DisplayName("Faca se nao for null")
    class DoIfNotNullTests {
        @Test
        @DisplayName("Com valor nao nulo")
        void doIfNotNull_valorNotNull() {
            AtomicReference<BigDecimal> bd = new AtomicReference<>(BigDecimal.ONE);

            DoIfNotNull.doIfNotNull(bigDecimal -> bd.set(bigDecimal.add(BigDecimal.ONE)), bd.get());

            assertEquals(BigDecimal.TWO, bd.get());
        }

        @Test
        @DisplayName("Com valor nulo")
        void doIfNotNull_valorNull() {
            AtomicReference<BigDecimal> bd = new AtomicReference<>(null);

            DoIfNotNull.doIfNotNull(bigDecimal -> bd.set(bigDecimal.add(BigDecimal.ONE)), bd.get());

            assertNull(bd.get());
        }
    }
}