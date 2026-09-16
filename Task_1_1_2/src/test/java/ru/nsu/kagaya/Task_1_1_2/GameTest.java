package ru.nsu.kagaya.Task_1_1_2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private final InputStream originIn = System.in;

    @AfterEach
    void clearInput() {
        System.setIn(originIn);
    }

    @Test
    void doDefaultRound1() {

        String simulatedInput = "y\ny\nn\nn\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
    @Test
    void doDefaultRound2() {

        String simulatedInput = "y\ny\nn\nn\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}