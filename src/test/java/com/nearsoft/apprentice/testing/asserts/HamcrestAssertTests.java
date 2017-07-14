package com.nearsoft.apprentice.testing.asserts;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.sameInstance;
import static org.hamcrest.Matchers.startsWith;

public class HamcrestAssertTests {

    @Test
    public void stringContainsValues() {
        String value = "albumen";
        assertThat(value, both(containsString("a"))
                .and(containsString("b")));
    }

    @Test
    public void listHasItems() {
        List<String> list = Arrays.asList("one", "two", "three");
        assertThat(list, hasItems("one", "three"));
    }

    @Test
    public void everyItemInListContainsString() {
        List<String> list = Arrays.asList("fun", "ban", "net");
        assertThat(list, everyItem(containsString("n")));
    }

    // Core Hamcrest Matchers with assertThat
    @Test
    public void hamcrestCoreMatchers() {
        assertThat("good", allOf(equalTo("good"), startsWith("good")));
        assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));
        assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
        assertThat(7, not(either(equalTo(3)).or(equalTo(4))));
        assertThat(new Object(), not(sameInstance(new Object())));
    }
}
