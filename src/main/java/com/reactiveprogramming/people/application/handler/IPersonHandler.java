package com.reactiveprogramming.people.application.handler;

import com.reactiveprogramming.people.application.dto.PersonRequestDto;
import com.reactiveprogramming.people.application.dto.PersonResponseDto;

import reactor.core.publisher.Mono;

public interface IPersonHandler {
  void savePerson(PersonRequestDto personRequestDto);
  Mono<PersonResponseDto> findPersonByEmail(String email);
}
