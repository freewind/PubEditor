package com.thoughtworks.pli.pub_editor.parser;

import scala.Some;

/**
 * Created by freewind on 14-4-13.
 */
public class TryLexer {

    public static void main(String[] args) {


        String input = "#!!!!!\n#????";
        PubSpecLexer lexer = new PubSpecLexer();
        lexer.start(input);
        for (int i = 0; i < 3; i++) {
            System.out.println(lexer.getTokenType());
            lexer.advance();
        }
    }
}
