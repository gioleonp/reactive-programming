package com.reactiveprogramming.people.infrastructure.out.persistence.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.reactiveprogramming.people.infrastructure.out.persistence.entity.PersonEntity;

import reactor.core.publisher.Mono;

public interface IPersonRepository extends ReactiveMongoRepository<PersonEntity, String> {
    Mono<PersonEntity> findByEmail(String email);
}
