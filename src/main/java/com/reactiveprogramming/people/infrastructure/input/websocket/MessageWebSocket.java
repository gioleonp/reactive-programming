package com.reactiveprogramming.people.infrastructure.input.websocket;

import com.reactiveprogramming.people.application.dto.MessageRequestDto;
import com.reactiveprogramming.people.application.dto.MessageResponseDto;
import com.reactiveprogramming.people.application.handler.IMessageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Controller
public class MessageWebSocket {

  private final IMessageHandler messageHandler;

  private WebClient client = WebClient.create("http://localhost:8080/message");

  @PostMapping
  public ResponseEntity<Void> saveMessage() {
    client
      .get()
      .retrieve()
      .bodyToMono(MessageRequestDto.class)
      .subscribe(message -> messageHandler.saveMessage(message));
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
