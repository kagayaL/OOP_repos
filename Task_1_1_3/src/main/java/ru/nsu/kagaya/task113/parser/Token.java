package ru.nsu.kagaya.task113.parser;

public enum Token {
    ADD('+', true),
    MUL('*', true),
    SUB('-', true),
    DIV('/', true),
    RIGHT_BORDER(')', false),
    LEFT_BORDER('(', false);

    private final char symbol;
    private final boolean isOperator;

    Token(char symbol, boolean isOperator) {
        this.isOperator = isOperator;
        this.symbol = symbol;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public boolean isOperator() {
        return this.isOperator;
    }

    public static Token getToken(char symbol) {
        for (Token token : Token.values()) {
            if (token.getSymbol() == symbol) {
                return token;
            }
        }
        return null;
    }

}
