package com.thoughtworks.pli.pub_editor.parser;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import scala.Some;

%%

%class _PubSpecLexer
%implements FlexLexer
%unicode
%type IElementType
%function advance
//%debug
%{
private String matchedText() {
    return yytext().toString();
}
private Some<String> someText() {
    return new Some<String>(yytext().toString());
}
%}

Comment = "#" .*
NewLine = \r\n | \r | \n

%%

{Comment} { return PubTokenTypes.comment(matchedText()); }
{NewLine} { return PubTokenTypes.newLine(); }
.         { return PubTokenTypes.badCharacter(matchedText()); }