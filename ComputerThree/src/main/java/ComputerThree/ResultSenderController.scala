package ComputerThree

import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(path = Array("/ComputerThree"))
class ResultSenderController {

  @RequestMapping(path = Array("/forwardResults/{results}"))
  def testMethod( @PathVariable("results") results: String){

    var resultSender = new ResultSender()
    resultSender.forwardResultsToOne(results)

  }

}
