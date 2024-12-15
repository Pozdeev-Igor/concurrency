package org.example.b2_three_stooges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeStoogesTest {

    private final ThreeStooges stooges = new ThreeStooges();

    @Test
    void isStoogeTest() {
        assertTrue(stooges.isStooge("Larry"));
        assertFalse(stooges.isStooge("Bob"));
    }

    @Test
    void getStoogeNamesTest() {
        assertNotEquals(stooges.getStoogeNames(), "[Larry, Curly]");
        assertEquals(stooges.getStoogeNames(), "[Moe, Larry, Curly]");
    }
}