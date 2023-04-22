package com.reactiveprogramming.people.domain.api;

import com.reactiveprogramming.people.domain.model.MessageModel;
import reactor.core.publisher.Flux;

public interface IMessageServicePort {
  void saveMessage(MessageModel messageModel);
  Flux<MessageModel> findAllByIdUser(int idUser);
}
