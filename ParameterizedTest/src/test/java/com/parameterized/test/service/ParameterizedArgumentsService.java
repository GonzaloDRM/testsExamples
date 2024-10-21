package com.parameterized.test.service;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class ParameterizedArgumentsService implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(1L, null),
                Arguments.of(2L, NoSuchElementException.class)
        );
    }
}
