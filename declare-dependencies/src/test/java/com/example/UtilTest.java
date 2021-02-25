package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class UtilTest {
    @Test
    public void testPeek() {
        assertEquals(1, Util.peek(1));
    }
}
