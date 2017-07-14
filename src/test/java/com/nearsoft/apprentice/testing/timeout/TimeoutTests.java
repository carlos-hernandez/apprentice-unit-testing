package com.nearsoft.apprentice.testing.timeout;

import org.junit.Test;

public class TimeoutTests {

    @Test(timeout = 1000)
    public void infinity() {
        while (true) ;
    }

    @Test(timeout = 5000)
    public void slowMethod() throws InterruptedException {
        Thread.sleep(10000);
    }
}
