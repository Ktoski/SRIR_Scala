package AppStart

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class FirstRunner{}

object FirstRunner extends App {

    SpringApplication.run(classOf[FirstRunner]);

}
