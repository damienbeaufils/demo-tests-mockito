package com.example.demo.service;

import com.example.demo.domain.Dummy;
import com.example.demo.exception.DummyServiceException;
import com.example.demo.repository.DummyRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DummyServiceImplTest {

    private DummyService dummyService;

    @Mock
    private DummyRepository dummyRepository;

    @Before
    public void setUp() {
        dummyService = new DummyServiceImpl(dummyRepository);
    }

    @Test
    public void doSomething_with_when() {
        // given
        LocalDate localDate = LocalDate.of(1988, 3, 28);

        List<Dummy> dummies = asList(new Dummy(1L, "test"));
        when(dummyRepository.findAll()).thenReturn(dummies);
        // when(dummyRepository.findAll()).thenReturn(asList(1, 2, 3));

        // when
        String result = dummyService.doSomething(localDate);

        // then
        assertThat(result).isEqualTo("service called at 1988-03-28 with result from repository [Dummy(id=1, name=test)]");
    }

    @Test
    public void doSomething_with_doReturn() {
        // given
        LocalDate localDate = LocalDate.of(1988, 3, 28);

        List<Dummy> dummies = asList(new Dummy(1L, "test"));
        doReturn(dummies).when(dummyRepository).findAll();

        // when
        String result = dummyService.doSomething(localDate);

        // then
        assertThat(result).isEqualTo("service called at 1988-03-28 with result from repository [Dummy(id=1, name=test)]");
    }

    @Test
    public void doSomething_with_bad_doReturn() {
        // given
        LocalDate localDate = LocalDate.of(1988, 3, 28);

        List<Integer> anotherListOfAnotherType = asList(1, 2, 3);
        doReturn(anotherListOfAnotherType).when(dummyRepository).findAll();

        // when
        String result = dummyService.doSomething(localDate);

        // then
        assertThat(result).isEqualTo("service called at 1988-03-28 with result from repository [1, 2, 3]");
    }

    @Test
    public void doSomething_with_catchThrowable() {
        // given
        RuntimeException rootException = new RuntimeException("error message");
        when(dummyRepository.findAll()).thenThrow(rootException);

        // when
        Throwable throwable = catchThrowable(() -> dummyService.doSomething(LocalDate.now()));

        // then
        assertThat(throwable).isInstanceOf(DummyServiceException.class)
                .hasMessage("error when doing something, please call 911")
                .hasCause(rootException);
    }

    @Test
    public void doSomethingElse_with_argumentCaptor() {
        // given
        LocalDate localDate = LocalDate.of(1988, 3, 28);

        // when
        dummyService.doSomethingElse(localDate);

        // then
        ArgumentCaptor<LocalDate> localDateArgumentCaptor = ArgumentCaptor.forClass(LocalDate.class);
        verify(dummyRepository).findDummiesCreatedAtSpecificDay(localDateArgumentCaptor.capture());
        assertThat(localDateArgumentCaptor.getValue()).isEqualTo(LocalDate.of(1988, 3, 27));
    }
}
