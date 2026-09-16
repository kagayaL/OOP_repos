package ru.nsu.kagaya.Task_1_1_2;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class MainTest {

    private final InputStream originIn = System.in;

    @AfterEach
    void clearInput() {
        System.setIn(originIn);
    }

    @Test
    void testMainExecution() {

        String simulatedInput = "y\nn\nn\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}