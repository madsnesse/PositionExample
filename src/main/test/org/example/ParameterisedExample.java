package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterisedExample {
    @ParameterizedTest
    @ValueSource(ints = {2,4,6,8,10,29064})
    void testIsEvenMethod(int a) {
        assertTrue(isEven(a));
    }

    @ParameterizedTest
    @MethodSource("intProvider")
    void testIsEvenMethodWithMethodSource(int a) {
        assertFalse(isEven(a));
    }

    public static boolean isEven(int a) {
        return a % 2 == 0;
    }

    public static Stream<Arguments> intProvider() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(3),
                Arguments.of(5),
                Arguments.of(7),
                Arguments.of(9),
                Arguments.of(2905)
        );
    }
}
