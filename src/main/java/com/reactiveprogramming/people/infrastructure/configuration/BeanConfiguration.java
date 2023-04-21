package com.reactiveprogramming.people.infrastructure.configuration;

import com.reactiveprogramming.people.domain.api.IPersonServicePort;
import com.reactiveprogramming.people.domain.spi.IPersonPersistencePort;
import com.reactiveprogramming.people.domain.usecase.PeopleUseCase;
import com.reactiveprogramming.people.infrastructure.out.persistence.adapter.PersonJpaAdapter;
import com.reactiveprogramming.people.infrastructure.out.persistence.mapper.IPersonEntityMapper;
import com.reactiveprogramming.people.infrastructure.out.persistence.repository.IPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

  private final IPersonEntityMapper peopleEntityMapper;
  private final IPersonRepository peopleRepository;

  @Bean
  public IPersonPersistencePort peoplePersistencePort() {
    return new PersonJpaAdapter(peopleRepository, peopleEntityMapper);
  }

  @Bean
  public IPersonServicePort peopleServicePort() {
    return new PeopleUseCase(peoplePersistencePort());
  }
}
