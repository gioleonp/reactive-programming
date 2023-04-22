package com.reactiveprogramming.people.domain.spi;

import com.reactiveprogramming.people.domain.model.MessageModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMessagePersistencePort {
  Mono<MessageModel> saveMessage(MessageModel messageModel);
  Flux<MessageModel> findAllByIdUser(int idUser);
}
