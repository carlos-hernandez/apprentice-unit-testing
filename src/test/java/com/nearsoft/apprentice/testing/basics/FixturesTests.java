package com.nearsoft.apprentice.testing.basics;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

public class FixturesTests {

    private static ExpensiveManagedResource expensiveManagedResource;
    private ManagedResource managedResource;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("@BeforeClass - Executed once per test class.");
        expensiveManagedResource = new ExpensiveManagedResource();
    }

    @AfterClass
    public static void tearDownClass() throws IOException {
        System.out.println("@AfterClass - Executed once per test class.");
        expensiveManagedResource.close();
    }

    @Before
    public void setUp() {
        System.out.println("@Before - Executed before each test method.");
        managedResource = new ManagedResource();
    }

    @After
    public void tearDown() throws IOException {
        System.out.println("@After - Executed before each test method.");
        managedResource.close();
    }

    @Test
    public void one() {
        System.out.println("@Test - One");
    }

    @Test
    public void two() {
        System.out.println("@Test - Two");
    }
}
