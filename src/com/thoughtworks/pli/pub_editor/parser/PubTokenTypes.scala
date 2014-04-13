package com.thoughtworks.pli.pub_editor.parser

import com.intellij.psi.tree.IElementType
import com.thoughtworks.pli.pub_editor.PubLanguage

class PubTokenTypes

object PubTokenTypes {

  def badCharacter(value: String) = new PubElementType("BadCharacter", Some(value))

  def comment(value: String) = new PubElementType("Comment", Some(value))

  def newLine = new PubElementType("NewLine")

}

class PubElementType[T](elementType: String, value: Option[T] = None) extends IElementType(elementType, PubLanguage) {

  override def toString = elementType + value.map(v => s" ($v)").getOrElse("")

}

