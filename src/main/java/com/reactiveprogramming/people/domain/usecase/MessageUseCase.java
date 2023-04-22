package com.reactiveprogramming.people.domain.usecase;

import com.reactiveprogramming.people.domain.api.IMessageServicePort;
import com.reactiveprogramming.people.domain.model.MessageModel;
import com.reactiveprogramming.people.domain.spi.IMessagePersistencePort;
import reactor.core.publisher.Flux;

public class MessageUseCase implements IMessageServicePort {

  private final IMessagePersistencePort messagePersistencePort;

  public MessageUseCase(IMessagePersistencePort messagePersistencePort) {
    this.messagePersistencePort = messagePersistencePort;
  }

  @Override
  public void saveMessage(MessageModel messageModel) {
    messagePersistencePort.saveMessage(messageModel).subscribe();
  }

  @Override
  public Flux<MessageModel> findAllByIdUser(int idUser) {
    return messagePersistencePort.findAllByIdUser(idUser);
  }
}
