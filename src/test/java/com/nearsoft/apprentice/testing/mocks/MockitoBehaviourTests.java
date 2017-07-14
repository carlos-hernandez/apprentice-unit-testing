package com.nearsoft.apprentice.testing.mocks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockitoBehaviourTests {

    @Mock
    private List<String> mockedList;

    @Spy
    private List<String> spyList = new ArrayList<String>();

    @Test
    public void configureSimpleReturnBehaviorForMock() {
        when(mockedList.add(anyString())).thenReturn(false);

        boolean added = mockedList.add(randomAlphabetic(6));
        assertThat(added, is(false));
    }

    @Test
    public void configureReturnBehaviorForMockInAnAlternativeWay() {
        doReturn(false).when(mockedList).add(anyString());

        boolean added = mockedList.add(randomAlphabetic(6));
        assertThat(added, is(false));
    }

    @Test(expected = IllegalStateException.class)
    public void configureMockToThrowAnExceptionOnMethodCall() {
        when(mockedList.add(anyString())).thenThrow(IllegalStateException.class);

        mockedList.add(randomAlphabetic(6));
    }

    @Test(expected = NullPointerException.class)
    public void configureBehaviorOfMethodWithVoidReturnTypeToThrowException() {
        doThrow(NullPointerException.class).when(mockedList).clear();

        mockedList.clear();
    }

    @Test(expected = IllegalStateException.class)
    public void configureTheBehaviorOfMultipleCalls() {
        when(mockedList.add(anyString()))
                .thenReturn(false)
                .thenThrow(IllegalStateException.class);

        mockedList.add(randomAlphabetic(6));
        mockedList.add(randomAlphabetic(6)); // will throw the exception
    }

    @Test(expected = NullPointerException.class)
    public void configureBehaviorOfSpy() {
        doThrow(NullPointerException.class).when(spyList).size();
        spyList.size(); // will throw the exception
    }
}
