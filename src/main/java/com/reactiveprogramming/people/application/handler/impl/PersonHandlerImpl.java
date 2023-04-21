package com.reactiveprogramming.people.application.handler.impl;

import com.reactiveprogramming.people.application.dto.PersonRequestDto;
import com.reactiveprogramming.people.application.dto.PersonResponseDto;
import com.reactiveprogramming.people.application.handler.IPersonHandler;
import com.reactiveprogramming.people.application.mapper.IPersonRequestDtoMapper;
import com.reactiveprogramming.people.application.mapper.IPersonResponseDtoMapper;
import com.reactiveprogramming.people.domain.api.IPersonServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonHandlerImpl implements IPersonHandler {

  private final IPersonServicePort personServicePort;
  private final IPersonRequestDtoMapper personRequestDtoMapper;
  private final IPersonResponseDtoMapper personResponseDtoMapper;

  @Override
  public void savePerson(PersonRequestDto personRequestDto) {
    personServicePort.savePeople(
      personRequestDtoMapper.toModel(personRequestDto)
    );
  }

  @Override
  public Mono<PersonResponseDto> findPersonByEmail(String email) {
    return personServicePort
      .findPeopleByEmail(email)
      .map(personResponseDtoMapper::toResponseDto);
  }
}
