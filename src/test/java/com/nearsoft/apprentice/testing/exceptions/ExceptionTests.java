package com.nearsoft.apprentice.testing.exceptions;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public class ExceptionTests {

    @Test(expected = IndexOutOfBoundsException.class)
    public void expectingExceptionWithAnnotation() {
        new ArrayList<>().get(0);
    }

    @Test
    public void oldSchoolExceptionTesting() {
        try {
            new ArrayList<>().get(0);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException exception) {
            assertThat(exception.getMessage(), is("Index: 0, Size: 0"));
        }
    }
}
