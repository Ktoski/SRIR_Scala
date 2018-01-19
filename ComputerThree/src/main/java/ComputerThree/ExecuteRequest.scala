package ComputerThree

import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient


class ExecuteRequest {

  var host = "localhost:8090"

  var client = new DefaultHttpClient()
  var request = new HttpGet("http://" + host + "/ComputerTwo/execute")
  var response = client.execute(request)



}
