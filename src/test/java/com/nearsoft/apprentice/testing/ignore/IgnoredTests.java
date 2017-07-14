package com.nearsoft.apprentice.testing.ignore;

import org.junit.Ignore;
import org.junit.Test;

public class IgnoredTests {

    @Test
    public void runTest() {
        System.out.println("This test is executed.");
    }

    @Ignore("Test is ignored as a demonstration")
    @Test
    public void ignoreTest() {
        System.out.println("This test is ignored.");
    }
}
