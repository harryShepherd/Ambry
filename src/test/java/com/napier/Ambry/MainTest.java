package com.napier.Ambry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MainTest {
    @Test
    void mainTest() {
        String arr[] = { };
        // this test is only supposed to be run in github actions
        assertDoesNotThrow(() -> Main.main(arr));
    }

}
