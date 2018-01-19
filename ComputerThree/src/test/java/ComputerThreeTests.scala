import ComputerThree.{ExecuteRequest, ResultSender}
import org.scalatest.FunSuite

class ComputerThreeTests  extends FunSuite{

  test("test executing program request"){

    var executeRequest = new ExecuteRequest()
  }

  test("test receiving and forwarding results"){

    var resultSender = new ResultSender()
    resultSender.forwardResultsToOne("results_from_test_three")
  }

}
