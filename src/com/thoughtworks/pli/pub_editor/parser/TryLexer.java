package com.thoughtworks.pli.pub_editor.parser;

public class TryLexer {

    public static void main(String[] args) {
        String input = "#!!!!!\n#????\nabc";
        PubSpecLexer lexer = new PubSpecLexer();
        lexer.start(input);
        for (int i = 0; i < 10; i++) {
            System.out.println(lexer.getTokenType() + "(" + lexer.getTokenText() + ")");
            lexer.advance();
        }
    }
}
