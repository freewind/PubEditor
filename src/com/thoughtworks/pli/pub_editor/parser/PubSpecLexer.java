package com.thoughtworks.pli.pub_editor.parser;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class PubSpecLexer extends FlexAdapter {
    public PubSpecLexer() {
        super(new _PubSpecLexer((Reader) null));
    }
}
