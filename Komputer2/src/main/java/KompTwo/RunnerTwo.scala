package KompTwo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
class RunnerTwo {}

  object RunnerTwo extends App {

    var sendRequest = new SendRequest();
    var sendConfirmation = new SendConfirmation();

    SpringApplication.run(classOf[RunnerTwo]);

    var compileFile = new CompileAndExecuteFile();
    compileFile.compile()

  }


