package com.reactiveprogramming.people.infrastructure.configuration;

import com.reactiveprogramming.people.domain.api.IMessageServicePort;
import com.reactiveprogramming.people.domain.api.IPersonServicePort;
import com.reactiveprogramming.people.domain.spi.IMessagePersistencePort;
import com.reactiveprogramming.people.domain.spi.IPersonPersistencePort;
import com.reactiveprogramming.people.domain.usecase.MessageUseCase;
import com.reactiveprogramming.people.domain.usecase.PeopleUseCase;
import com.reactiveprogramming.people.infrastructure.out.persistence.adapter.MessageJpaAdapter;
import com.reactiveprogramming.people.infrastructure.out.persistence.adapter.PersonJpaAdapter;
import com.reactiveprogramming.people.infrastructure.out.persistence.mapper.IMessageEntityMapper;
import com.reactiveprogramming.people.infrastructure.out.persistence.mapper.IPersonEntityMapper;
import com.reactiveprogramming.people.infrastructure.out.persistence.repository.IMessageRepository;
import com.reactiveprogramming.people.infrastructure.out.persistence.repository.IPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

  private final IPersonEntityMapper peopleEntityMapper;
  private final IPersonRepository peopleRepository;
  private final IMessageRepository messageRepository;
  private final IMessageEntityMapper messageEntityMapper;

  @Bean
  public IPersonPersistencePort peoplePersistencePort() {
    return new PersonJpaAdapter(peopleRepository, peopleEntityMapper);
  }

  @Bean
  public IPersonServicePort peopleServicePort() {
    return new PeopleUseCase(peoplePersistencePort());
  }

  @Bean
  public IMessagePersistencePort messagePersistencePort() {
    return new MessageJpaAdapter(messageRepository, messageEntityMapper);
  }

  @Bean
  public IMessageServicePort messageServicePort() {
    return new MessageUseCase(messagePersistencePort());
  }
}
