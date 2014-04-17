package com.thoughtworks.pli.pub_editor.parser

import com.intellij.psi.tree.IElementType
import com.thoughtworks.pli.pub_editor.PubLanguage

class PubTokenTypes

object PubTokenTypes {

  val BadCharacter = new PubElementType("BadCharacter")

  val Comment = new PubElementType("Comment")

  val LineSeparator = new PubElementType("LineSeparator")

}

class PubElementType[T](elementType: String, value: Option[T] = None) extends IElementType(elementType, PubLanguage) {

  override def toString = elementType + value.map(v => s" ($v)").getOrElse("")

}

