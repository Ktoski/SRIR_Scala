package ComputerThree

import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient


class ResultSender {

  def forwardResultsToOne(args: String) {

    var contentOfResult = args

    var host = "localhost:8080"

    var client = new DefaultHttpClient()
    var request = new HttpGet("http://" + host + "/ComputerOne/result/" + contentOfResult)
    var response = client.execute(request)
  }

}
