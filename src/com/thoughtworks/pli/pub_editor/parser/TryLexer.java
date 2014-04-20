package com.thoughtworks.pli.pub_editor.parser;

import com.intellij.psi.tree.IElementType;

public class TryLexer {

    public static void main(String[] args) {
        String input = "#!!!!!\n" +
                "#????\n" +
                "abc: \"sss\"\n" +
                "xxx:\n" +
                "  aaa: 111\n" +
                "  bbb: 222\n" +
                "yyy: >\n" +
                "  1111111111111\n" +
                "    2222222222222\n" +
                "  3333333333333\n" +
                "zzz: ZZZ\n" +
                "  ccc: This line actually is invalid\n" +
                "???";
        PubSpecLexer lexer = new PubSpecLexer();
        lexer.start(input);
        while (true) {
            IElementType tokenType = lexer.getTokenType();
            if (tokenType == null) {
                System.out.println("--- end ---");
                return;
            }
            
            System.out.println(tokenType + "(" + lexer.getTokenText() + ")");
            lexer.advance();
        }
    }
}
