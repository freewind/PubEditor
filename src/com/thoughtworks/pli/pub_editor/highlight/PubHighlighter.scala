package com.thoughtworks.pli.pub_editor.highlight

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import com.thoughtworks.pli.pub_editor.parser.PubSpecLexer
import com.thoughtworks.pli.pub_editor.parser.PubTokenTypes
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors

class PubHighlighter extends SyntaxHighlighterBase {

  object keys {
    val Comment = newKey("Pub.Comment", DefaultLanguageHighlighterColors.LINE_COMMENT)
    val KnownKey = newKey("Pub.KnownKey", DefaultLanguageHighlighterColors.KEYWORD)
    val UnknownKey = newKey("Pub.UnknownKey", DefaultLanguageHighlighterColors.INSTANCE_FIELD)
    val Value = newKey("Pub.Value", DefaultLanguageHighlighterColors.MARKUP_ENTITY)
    val String = newKey("Pub.String", DefaultLanguageHighlighterColors.STRING)
    val Unknown = newKey("Pub.Unknown", DefaultLanguageHighlighterColors.BLOCK_COMMENT)

    def newKey(keyId: String, color: TextAttributesKey): TextAttributesKey = {
      TextAttributesKey.createTextAttributesKey(keyId, color)
    }
  }

  def getHighlightingLexer: Lexer = new PubSpecLexer

  def getTokenHighlights(tokenType: IElementType): Array[TextAttributesKey] = {
    import PubTokenTypes._
    tokenType match {
      case Comment => Array(keys.Comment)
      case OneLineOfMultiLineString => Array(keys.String)
      case BadCharacter => Array(keys.Unknown)
      case KnownKey => Array(keys.KnownKey)
      case key if List(MultiLineStringKey, ParentKey, InlineKey).contains(key) => Array(keys.UnknownKey)
      case _ => Array()
    }
  }

}

