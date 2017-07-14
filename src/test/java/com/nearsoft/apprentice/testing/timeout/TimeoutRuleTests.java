package com.nearsoft.apprentice.testing.timeout;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeUnit;

public class TimeoutRuleTests {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1);

    @Test
    public void slowMethod() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
    }
}
