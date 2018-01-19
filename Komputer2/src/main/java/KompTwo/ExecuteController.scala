package KompTwo

import org.springframework.web.bind.annotation.{RequestMapping, RestController}


@RestController
@RequestMapping(path = Array("/ComputerTwo"))
class ExecuteController {

  @RequestMapping(path = Array("/execute"))
  def testMethod(){

    val executeFile = new CompileAndExecuteFile()

    executeFile.executeProgram()
    executeFile.sendResultsToThree()

  }

}
