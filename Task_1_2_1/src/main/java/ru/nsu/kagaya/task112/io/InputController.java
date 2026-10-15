package ru.nsu.kagaya.task112.io;

import java.util.Scanner;

public class InputController {
    private final Scanner _scanner;

    public InputController() {
        _scanner = new Scanner(System.in);
    }

    public String getLine() {
        return _scanner.next();
    }

}
