package com.reactiveprogramming.people.application.handler.impl;

import com.reactiveprogramming.people.application.dto.MessageRequestDto;
import com.reactiveprogramming.people.application.dto.MessageResponseDto;
import com.reactiveprogramming.people.application.handler.IMessageHandler;
import com.reactiveprogramming.people.application.mapper.IMessageRequestDtoMapper;
import com.reactiveprogramming.people.application.mapper.IMessageResponseDtoMapper;
import com.reactiveprogramming.people.domain.api.IMessageServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

@Service
@Transactional
@RequiredArgsConstructor
public class MessageHandlerImpl implements IMessageHandler {

  private final IMessageServicePort messageServicePort;
  private final IMessageRequestDtoMapper messageRequestDtoMapper;
  private final IMessageResponseDtoMapper messageResponseDtoMapper;

  @Override
  public void saveMessage(MessageRequestDto messageRequestDto) {
    messageServicePort.saveMessage(
      messageRequestDtoMapper.toModel(messageRequestDto)
    );
  }

  @Override
  public Flux<MessageResponseDto> findAllByIdUser(int idUser) {
    return messageServicePort
      .findAllByIdUser(idUser)
      .map(messageResponseDtoMapper::toResponseDto);
  }
}
