package com.reactiveprogramming.people.infrastructure.input.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

  @GetMapping
  public ResponseEntity<String> gretting() {
    return ResponseEntity.ok("hello world!");
  }
}
