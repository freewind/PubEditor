package com.thoughtworks.pli.pub_editor

import com.intellij.openapi.fileTypes.LanguageFileType
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable
import javax.swing.Icon
import com.intellij.openapi.util.IconLoader

class PubFileType extends LanguageFileType(PubLanguage) {

  @NotNull
  override def getName = "Pub"

  @NotNull
  override def getDescription = "Dart's Pub File"

  @NotNull
  override def getDefaultExtension = ""

  @Nullable
  override def getIcon: Icon = IconLoader.getIcon("/com/thoughtworks/pli/pub_editor/pub_file.png")

}

object PubFileType extends PubFileType
