package com.reactiveprogramming.people.application.handler;

import com.reactiveprogramming.people.application.dto.MessageRequestDto;
import com.reactiveprogramming.people.application.dto.MessageResponseDto;
import reactor.core.publisher.Flux;

public interface IMessageHandler {
  void saveMessage(MessageRequestDto messageRequestDto);
  Flux<MessageResponseDto> findAllByIdUser(int idUser);
}
