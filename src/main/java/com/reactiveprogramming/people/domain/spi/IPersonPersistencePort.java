package com.reactiveprogramming.people.domain.spi;

import com.reactiveprogramming.people.domain.model.PersonModel;
import reactor.core.publisher.Mono;

public interface IPersonPersistencePort {
  Mono<PersonModel> savePeople(PersonModel peopleModel);

  Mono<PersonModel> findPeopleByEmail(String email);
}
