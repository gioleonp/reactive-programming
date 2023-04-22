package com.reactiveprogramming.people.domain.api;

import com.reactiveprogramming.people.domain.model.PersonModel;

import reactor.core.publisher.Mono;

public interface IPersonServicePort {

    Mono<PersonModel> savePeople(PersonModel peopleModel);

    Mono<PersonModel> findPeopleByEmail(String email);
    
}
