package KompTwo

import org.apache.http.client.methods.{HttpPost}
import org.apache.http.impl.client.{ HttpClients}


class SendConfirmation {


  var host = "localhost:8080"

  var httpclient = HttpClients.createDefault();
  var post = new HttpPost("http://" + host + "/ComputerOne/confirmation");
  var response = httpclient.execute(post);
  var entity = response.getEntity();

  if (entity != null) {

    var instream = entity.getContent();
    try {
      println(instream.toString)
    } finally {
      instream.close();
    }
  }


}
