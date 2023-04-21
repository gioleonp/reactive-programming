package com.reactiveprogramming.people.infrastructure.input.rest;

import com.reactiveprogramming.people.application.dto.PersonRequestDto;
import com.reactiveprogramming.people.application.dto.PersonResponseDto;
import com.reactiveprogramming.people.application.handler.IPersonHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonRestController {

  private final IPersonHandler personHandler;

  @GetMapping
  public ResponseEntity<Mono<PersonResponseDto>> findPersonByEmail(
    @RequestParam String email
  ) {
    return ResponseEntity.ok(personHandler.findPersonByEmail(email));
  }

  @PostMapping
  public ResponseEntity<Void> savePerson(
    @RequestBody PersonRequestDto personRequestDto
  ) {
    personHandler.savePerson(personRequestDto);
    return new ResponseEntity<Void>(HttpStatus.CREATED);
  }
}
