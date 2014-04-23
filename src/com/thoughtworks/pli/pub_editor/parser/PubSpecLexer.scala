package com.thoughtworks.pli.pub_editor.parser

import java.io.Reader
import com.intellij.lexer.FlexAdapter

class PubSpecLexer extends FlexAdapter(new _PubSpecLexer(null.asInstanceOf[Reader]))