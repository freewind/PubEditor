package com.thoughtworks.pli.pub_editor.parser

import com.intellij.psi.tree.IElementType
import com.thoughtworks.pli.pub_editor.PubLanguage

class PubTokenTypes

object PubTokenTypes {

  val BadCharacter = new PubElementType("BadCharacter")

  val Comment = new PubElementType("Comment")

  val LineSeparator = new PubElementType("LineSeparator")

  val InlineKey = new PubElementType("InlineKey")

  val ChildrenKey = new PubElementType("ChildrenKey")

  val InlineValue = new PubElementType("InlineValue")

  val MultiLineStringKey = new PubElementType("MultiLineStartFlag")

  val OneLineOfMultiLineString = new PubElementType("OneLineOfMultiLineString")

  val Indentation = new PubElementType("Indentation")
}

class PubElementType[T](elementType: String, value: Option[T] = None) extends IElementType(elementType, PubLanguage) {

  override def toString = elementType + value.map(v => s" ($v)").getOrElse("")

}

