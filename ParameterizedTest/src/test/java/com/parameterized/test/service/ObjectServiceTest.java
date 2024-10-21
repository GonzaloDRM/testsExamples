package com.parameterized.test.service;

import com.parameterized.test.model.ObjectModel;
import com.parameterized.test.repository.ObjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith({MockitoExtension.class})
public class ObjectServiceTest {

    private ObjectService objectService;
    private ObjectModel objectModel;

    @Mock
    private ObjectRepository objectRepository;

    @BeforeEach
    void setUp(){
        objectModel = ObjectModel.builder().id(1L).name("name").build();
    }

    @ParameterizedTest
    @ArgumentsSource(ParameterizedArgumentsService.class)
    void testService(Long id, Class<? extends Exception> expectedException){
        given(objectRepository.findById(any())).willReturn(objectModel);
        Executable result = () -> objectService.testService(id);
        if (expectedException != null){
            assertThrows(expectedException, result);
        }else {
            assertEquals(result, objectModel);
        }
    }
}
