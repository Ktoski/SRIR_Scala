import KompTwo._
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient
import org.scalatest.FunSuite
import org.springframework.boot.SpringApplication

class ComputerTwoTests extends FunSuite{

  test("test request for file"){

    var sendRequest = new SendRequest()

  }

  test("test request for file with error"){

    var sendRequestForInvalid = new SendRequestForInvalidFile()

  }

  test("test sending confirmation"){

    var sendConfirmation = new SendConfirmation()

  }

  test("test compile file"){
    var compileFile = new CompileAndExecuteFile()
    compileFile.compile()
  }

  test("test compile invalid file"){
    var compileFile = new CompileAndExecuteFile()
    compileFile.compileInvalidFile()
    try {
      compileFile.executeProgramWithError()
    }catch{
      case cne: ClassNotFoundException => println("Error: Invalid File")
    }

  }

  test("test file execution"){

    SpringApplication.run(classOf[RunnerTwo]);

    var host = "localhost:8090"

    var client = new DefaultHttpClient()
    var request = new HttpGet("http://" + host + "/ComputerTwo/execute")
    var response = client.execute(request)

    var serviceAvailabilty = response.getEntity().getContent().available()
    assert(serviceAvailabilty == 0)

  }

  test("test sending results"){
    var compileFile = new CompileAndExecuteFile()
    compileFile.sendResultsToThree()

  }

}
