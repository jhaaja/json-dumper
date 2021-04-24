package net.ambientia.azurehello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

  @Value("${AZURE_HELLO_VERSION:0.1}")
  private String helloVersion;

  @GetMapping
  public String returnHello() {
    return "{\"version\": \"" + helloVersion + "\"}";
  }
}
