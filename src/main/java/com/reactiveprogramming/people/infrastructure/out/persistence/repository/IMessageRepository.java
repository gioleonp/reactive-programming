package com.reactiveprogramming.people.infrastructure.out.persistence.repository;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.reactiveprogramming.people.infrastructure.out.persistence.entity.MessageEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMessageRepository extends ReactiveMongoRepository<MessageEntity, String> {

    Mono<MessageEntity> save(MessageEntity messageEntity);
    Flux<MessageEntity> findAllByIdUser(int idUser);
    
}
