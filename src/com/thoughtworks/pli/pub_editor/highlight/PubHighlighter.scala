package com.thoughtworks.pli.pub_editor.highlight

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import com.thoughtworks.pli.pub_editor.parser.PubSpecLexer
import com.thoughtworks.pli.pub_editor.parser.PubTokenTypes
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.thoughtworks.pli.pub_editor.parser.PubTokenTypes._
import org.apache.commons.lang.StringUtils

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

  def getHighlightingLexer: Lexer = new PubWithKnownKeyLexer

  def getTokenHighlights(tokenType: IElementType): Array[TextAttributesKey] = {
    import PubTokenTypes._
    tokenType match {
      case Comment => Array(keys.Comment)
      case OneLineOfMultiLineString => Array(keys.String)
      case BadCharacter => Array(keys.Unknown)
      case KnownKey => Array(keys.KnownKey)
      case MultiLineStringKey | ParentKey | InlineKey => Array(keys.UnknownKey)
      case _ => Array()
    }
  }

}


class PubWithKnownKeyLexer extends PubSpecLexer {

  val KeyTypes = List(InlineKey, ParentKey, MultiLineStringKey)
  val KnownKeys = List(
    "name", "version", "description", "author",
    "homepage", "documentation", "dependencies", "dev_dependencies", "dependency_overrides"
  )

  override def getTokenType: IElementType = {
    val tokenType = super.getTokenType
    if (KeyTypes.contains(tokenType) && KnownKeys.contains(getKey(getTokenText)))
      PubTokenTypes.KnownKey
    else tokenType
  }

  private def getKey(token: String) = StringUtils.substringBefore(token, ":").trim.toLowerCase
}
