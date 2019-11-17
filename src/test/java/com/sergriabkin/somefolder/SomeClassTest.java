package com.sergriabkin.somefolder;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

class SomeClassTest {

    @Test
    public void someMethod() {
        int x = 1;
        assertEquals(x, new SomeClass().someMethod(x));
    }
}