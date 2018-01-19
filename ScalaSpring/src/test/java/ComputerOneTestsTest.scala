import java.io.{BufferedReader, InputStreamReader}
import java.util
import java.util.stream.Collectors
import AppStart.FirstRunner
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient
import Files.FileRepository
import org.scalatest.FunSuite
import org.springframework.boot.SpringApplication

class ComputerOneTestsTest extends FunSuite {

  var host = "localhost:8080"
  var client = new DefaultHttpClient()

  test("test file repository") {

    var fileRepository = new FileRepository
    assert(fileRepository.getFile() != null)

    assert(fileRepository.getFileWithError() != null)

  }

  test("test file availability"){

    SpringApplication.run(classOf[FirstRunner]);

    var request = new HttpGet("http://" + host + "/ComputerOne/file")
    var response = client.execute(request)
    var rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()))

    var listOfLines = new util.ArrayList[String](rd.lines().collect(Collectors.toList()))

    assert(listOfLines.size() != 0)
  }

  test("test file with error availability"){


    var request = new HttpGet("http://" + host + "/ComputerOne/fileWithError")
    var response = client.execute(request)
    var rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()))

    var listOfLines = new util.ArrayList[String](rd.lines().collect(Collectors.toList()))

    assert(listOfLines.size() != 0)

  }

  test("test confirmation service"){
    //SpringApplication.run(classOf[Hello]);

    var request = new HttpGet("http://" + host + "/ComputerOne/confirmation")
    var response = client.execute(request)
    var rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()))

    assert(rd != null)

  }

  test("test receiving results service"){

    var request = new HttpGet("http://" + host + "/ComputerOne//result/" + "resultsForTests")
    var client = new DefaultHttpClient()
    var response = client.execute(request)
    var rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()))
    var serviceAvailabilty = response.getEntity().getContent().available()
    assert(serviceAvailabilty == 0)

  }


}
