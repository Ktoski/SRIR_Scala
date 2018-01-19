package AppStart

import Files.FileRepository
import org.springframework.web.bind.annotation._


@RestController
@RequestMapping(path = Array("/ComputerOne"))
class ComputerOneController {

  var fileRepository = new FileRepository;

  @RequestMapping(path = Array("/file"))
  def returnFile1(): Array[Byte] ={

    fileRepository.getFile()

  }

  @RequestMapping(path = Array("/fileWithError"))
  def returnFileWithError1(): Array[Byte] ={

    fileRepository.getFileWithError()

  }

  @RequestMapping(path = Array("/confirmation"), method = Array(RequestMethod.POST))
  def getConfirmation(){

    System.out.println("File send and received by Two !");

  }

  @RequestMapping(path = Array("/result/{result}")/*, method = Array(RequestMethod.POST)*/)
  def getResult(@PathVariable("result") result: String){

    System.out.println("Result of the program: " + result);

  }

}
