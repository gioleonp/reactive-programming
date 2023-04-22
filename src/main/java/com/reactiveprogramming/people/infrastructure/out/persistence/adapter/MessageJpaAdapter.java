package com.reactiveprogramming.people.infrastructure.out.persistence.adapter;

import java.time.LocalDateTime;

import com.reactiveprogramming.people.domain.model.MessageModel;
import com.reactiveprogramming.people.domain.spi.IMessagePersistencePort;
import com.reactiveprogramming.people.infrastructure.out.persistence.entity.MessageEntity;
import com.reactiveprogramming.people.infrastructure.out.persistence.mapper.IMessageEntityMapper;
import com.reactiveprogramming.people.infrastructure.out.persistence.repository.IMessageRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class MessageJpaAdapter implements IMessagePersistencePort {

  private final IMessageRepository messageRepository;
  private final IMessageEntityMapper messageEntityMapper;

  @Override
  public Mono<MessageModel> saveMessage(MessageModel messageModel) {
    MessageEntity messageEntity = messageEntityMapper.toEntity(messageModel);
    messageEntity.setDate(LocalDateTime.now());

    return messageRepository
      .save(messageEntity)
      .map(messageEntityMapper::toModel);
  }

  @Override
  public Flux<MessageModel> findAllByIdUser(int idUser) {
    return messageRepository
      .findAllByIdUser(idUser)
      .map(messageEntityMapper::toModel)
      .switchIfEmpty(Mono.error(new RuntimeException("NO DATA FOUND")));
  }
}
