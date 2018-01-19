package KompTwo

import java.io._
import java.util
import java.util.stream.Collectors
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient;


class SendRequest {

  var host = "localhost:8080"

  var client = new DefaultHttpClient()
  var request = new HttpGet("http://" + host + "/ComputerOne/file")
  var response = client.execute(request)
  var rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()))

  var listOfLines = new util.ArrayList[String](rd.lines().collect(Collectors.toList()))
  System.out.println("size: " + listOfLines.size())

  for( i <- 0 until listOfLines.size()){

    System.out.println("lines: " + listOfLines.get(i))
  }


  val pw = new PrintWriter(new File("src/main/resources/ProgramP.scala" ))
  for( i <- 0 until listOfLines.size()){

    pw.write(listOfLines.get(i))
  }

  pw.close

}
