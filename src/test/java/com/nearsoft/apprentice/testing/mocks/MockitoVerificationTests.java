package com.nearsoft.apprentice.testing.mocks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

@RunWith(MockitoJUnitRunner.class)
public class MockitoVerificationTests {

    @Mock
    private List<String> mockedList;

    @Test
    public void verifySimpleInvocationOnMock() {
        mockedList.size();
        verify(mockedList).size();
    }

    @Test
    public void verifyNumberOfInteractionsWithMock() {
        mockedList.size();
        verify(mockedList, times(1)).size();
    }

    @Test
    public void verifyNoInteractionWithTheWholeMockOccurred() {
        verifyZeroInteractions(mockedList);
    }

    @Test
    public void verifyNoInteractionWithSpecificMethodOccurred() {
        verify(mockedList, times(0)).size();
    }

    @Test
    public void verifyThereAreNoUnexpectedInteractionsAndThrowException() {
        mockedList.size();
        mockedList.clear();
        verify(mockedList).size();
        verifyNoMoreInteractions(mockedList);
    }

    @Test
    public void verifyAnInteractionHasNotOccurred() {
        mockedList.size();
        verify(mockedList, never()).clear();
    }

    @Test
    public void verifyAnInteractionHasOccurredAtLeastCertainNumberOfTimes() {
        mockedList.clear();
        mockedList.clear();
        mockedList.clear();

        verify(mockedList, atLeast(1)).clear();
        verify(mockedList, atMost(10)).clear();
    }

    @Test
    public void verifyInteractionWithExactArgument() {
        mockedList.add("test");
        verify(mockedList).add("test");
    }

    @Test
    public void verifyInteractionWithAnyArgument() {
        mockedList.add("test");
        verify(mockedList).add(anyString());
    }
}
