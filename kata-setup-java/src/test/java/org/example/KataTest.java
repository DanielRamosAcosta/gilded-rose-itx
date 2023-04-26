package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class KataTest {
    @Test
    void should_work_with_dependency_implementation() {
        var dependency = new DependencyImpl();
        var kata = new Kata(dependency);

        int actual = kata.getValue();

        assertThat(actual).isEqualTo(0);
    }

    @Test
    void should_work_with_mock_dependency() {
        var mockedDependency = Mockito.mock(Dependency.class);
        when(mockedDependency.getValue()).thenReturn(42);
        var kata = new Kata(mockedDependency);


        int actual = kata.getValue();

        assertThat(actual).isEqualTo(42);
        verify(mockedDependency, times(1));
    }
}