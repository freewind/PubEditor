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

Comment = "#" .*
LineSeparator = \r\n | \r | \n

%%

{Comment}          { return PubTokenTypes.Comment(); }
{LineSeparator}    { return PubTokenTypes.LineSeparator(); }
.                  { return PubTokenTypes.BadCharacter(); }