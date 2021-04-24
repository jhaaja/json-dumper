package net.haaja.jsondumper.controller;

import com.fasterxml.jackson.databind.JsonNode;
import net.haaja.jsondumper.domain.JsonPayload;
import net.haaja.jsondumper.repository.JsonPayloadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/")
public class IndexController {

  @Autowired
  private JsonPayloadRepository repository;
  private Logger logger = LoggerFactory.getLogger(IndexController.class);

  @PostMapping(value = "/", produces = "application/json", consumes = "application/json")
  public ResponseEntity<?> receiveJsonPayload(@RequestBody JsonNode requestBody) {

    JsonPayload payload = new JsonPayload();
    payload.setReceiveTime(System.currentTimeMillis());
    payload.setContent(requestBody.toString());

    repository.save(payload);

    return new ResponseEntity<String>("{ \"status\": \"" + HttpStatus.OK.toString() + "\" }",
        HttpStatus.OK);
  }

  @GetMapping("/")
  public Iterable<JsonPayload> getAllReceived() {
    return repository.findAll();
  }

}
