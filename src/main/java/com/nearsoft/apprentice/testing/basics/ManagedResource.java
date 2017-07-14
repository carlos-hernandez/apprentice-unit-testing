package com.nearsoft.apprentice.testing.basics;

import java.io.Closeable;
import java.io.IOException;

public class ManagedResource implements Closeable {

    @Override
    public void close() throws IOException {
    }
}
