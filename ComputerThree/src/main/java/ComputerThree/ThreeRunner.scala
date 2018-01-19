package ComputerThree

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
class ThreeRunner {}

object ThreeRunner extends App {


  SpringApplication.run(classOf[ThreeRunner]);
  var executeRequest = new ExecuteRequest()
  //var resultSender = new ResultSender()


}
