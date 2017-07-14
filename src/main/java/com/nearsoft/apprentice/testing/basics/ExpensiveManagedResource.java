package com.nearsoft.apprentice.testing.basics;

import java.io.Closeable;
import java.io.IOException;

public class ExpensiveManagedResource implements Closeable {

    @Override
    public void close() throws IOException {
    }
}
