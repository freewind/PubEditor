package com.thoughtworks.pli.pub_editor

import com.intellij.openapi.fileTypes.{FileNameMatcher, FileTypeConsumer, FileTypeFactory}
import org.jetbrains.annotations.NotNull

class PubFileTypeFactory extends FileTypeFactory {

  val PubFileName = "pubspec.yaml"

  @Override
  override def createFileTypes(@NotNull fileTypeConsumer: FileTypeConsumer) = {
    fileTypeConsumer.consume(PubFileType, new FileNameMatcher {
      override def accept(fileName: String) = fileName == PubFileName
      override def getPresentableString: String = PubFileName
    })
  }

}
