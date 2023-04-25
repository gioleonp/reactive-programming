package com.reactiveprogramming.people.infrastructure.input.rest;

import com.reactiveprogramming.people.application.dto.MessageRequestDto;
import com.reactiveprogramming.people.application.handler.IMessageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController
// @RequestMapping("/message")
@RequiredArgsConstructor
public class MessageRestController {

  private final IMessageHandler messageHandler;

  @PostMapping
  public ResponseEntity<Void> saveMessage(
    @RequestBody MessageRequestDto messageRequestDto
  ) {
    messageHandler.saveMessage(messageRequestDto);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
