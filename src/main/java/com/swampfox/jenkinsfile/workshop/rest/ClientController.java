package com.swampfox.jenkinsfile.workshop.rest;

import com.swampfox.jenkinsfile.workshop.data.Version;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/api/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

  @RequestMapping(method = RequestMethod.GET, path = "/version")
  public ResponseEntity getVersion() {
    Version v = new Version();
    return new ResponseEntity<>(Map.of("version", v.getCurrentVersion()), HttpStatus.OK);
  }
}
