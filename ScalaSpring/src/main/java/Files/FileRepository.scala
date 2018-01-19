package Files

import java.nio.file.Files
import java.nio.file.Paths

class FileRepository {


  var filePath = "src/ProgramP.scala"
  var filePathError = "src/ProgramPError.scala"

  def getFile(): Array[Byte]={

    val byteArray = Files.readAllBytes(Paths.get(filePath))
    byteArray
  }

  def getFileWithError(): Array[Byte]={

    val byteArray = Files.readAllBytes(Paths.get(filePathError))
    byteArray
  }



}