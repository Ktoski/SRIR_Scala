package KompTwo

import java.io._
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient
import scala.io.Source
import scala.tools.nsc.{Global, Settings}


class CompileAndExecuteFile {


  def compile(): Unit ={

    val settings = new Settings()
    settings.deprecation.value = true
    settings.unchecked.value = true
    //settings.outputDirs.setSingleOutput("src/main/resources/ProgramP.scala")
    settings.usejavacp.value = true

    val g = new Global(settings)
    val run = new g.Run

    run.compile(List("src/main/resources/ProgramP.scala"))

  }

  def compileInvalidFile(): Unit ={

    val settings = new Settings()
    settings.deprecation.value = true
    settings.unchecked.value = true
    settings.usejavacp.value = true

    val g = new Global(settings)
    val run = new g.Run

    run.compile(List("src/main/resources/ProgramPWithError.scala"))

  }

  def executeProgram(): Unit ={

    val classLoader = new java.net.URLClassLoader(
      Array(new File(".").toURI.toURL),
      this.getClass.getClassLoader)

    val clazz = classLoader.loadClass("ProgramP")
    clazz.newInstance
  }

  def executeProgramWithError(): Unit ={

    val classLoader = new java.net.URLClassLoader(
      Array(new File(".").toURI.toURL),
      this.getClass.getClassLoader)

    val clazz = classLoader.loadClass("ProgramPWithError")
    clazz.newInstance
  }

  def sendResultsToThree(): Unit ={

    val resultOfProgramThree = Source.fromFile("ProgramP_Result.txt").getLines.mkString
    println(resultOfProgramThree.getClass)

    var host = "localhost:8095"

    var client = new DefaultHttpClient()
    var request = new HttpGet("http://" + host + "/ComputerThree/forwardResults/" + resultOfProgramThree)
    var response = client.execute(request)

  }

}
