package KompTwo

import java.io.{BufferedReader, File, InputStreamReader, PrintWriter}
import java.util
import java.util.stream.Collectors

import org.apache.http.client.methods.HttpGet

class SendRequestForInvalidFile extends SendRequest {

   var request2 = new HttpGet("http://" + host + "/ComputerOne/fileWithError")

   var response2 = client.execute(request2)
  var rd2 = new BufferedReader (new InputStreamReader(response2.getEntity().getContent()))

  var listOfLines2 = new util.ArrayList[String](rd2.lines().collect(Collectors.toList()))
  System.out.println("size2: " + listOfLines2.size())

  for( i <- 0 until listOfLines2.size()){

    System.out.println("lines: " + listOfLines2.get(i))
  }


  val pw2 = new PrintWriter(new File("src/main/resources/ProgramPWithError.scala" ))
  for( i <- 0 until listOfLines2.size()){

    pw2.write(listOfLines2.get(i))
  }

  pw2.close

}
