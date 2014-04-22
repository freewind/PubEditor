package com.thoughtworks.pli.pub_editor.parser

import org.apache.commons.lang.StringUtils
import java.io.Reader
import PubTokenTypes._
import com.intellij.lexer.FlexAdapter
import com.intellij.psi.tree.IElementType

class PubSpecLexer extends FlexAdapter(new _PubSpecLexer(null.asInstanceOf[Reader])) {
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


