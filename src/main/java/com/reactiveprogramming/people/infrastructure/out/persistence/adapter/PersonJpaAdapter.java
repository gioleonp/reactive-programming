package com.reactiveprogramming.people.infrastructure.out.persistence.adapter;

import com.reactiveprogramming.people.domain.model.PersonModel;
import com.reactiveprogramming.people.domain.spi.IPersonPersistencePort;
import com.reactiveprogramming.people.infrastructure.out.persistence.entity.PersonEntity;
import com.reactiveprogramming.people.infrastructure.out.persistence.mapper.IPersonEntityMapper;
import com.reactiveprogramming.people.infrastructure.out.persistence.repository.IPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class PersonJpaAdapter implements IPersonPersistencePort {

  private final IPersonRepository peopleRepository;
  private final IPersonEntityMapper peopleEntityMapper;

  @Override
  public Mono<PersonModel> savePeople(PersonModel peopleModel) {
    PersonEntity personEntity = peopleEntityMapper.toEntity(peopleModel);
    personEntity.setId("abccc");
    System.out.println(personEntity);
    return peopleRepository
      .save(personEntity)
      .map(people -> peopleEntityMapper.toModel(people));
  }

  @Override
  public Mono<PersonModel> findPeopleByEmail(String email) {
    return peopleRepository
      .findByEmail(email)
      .map(peopleEntityMapper::toModel)
      .switchIfEmpty(Mono.error(new RuntimeException("NO DATA FOUND")));
  }
}
