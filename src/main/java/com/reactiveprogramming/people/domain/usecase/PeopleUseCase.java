package com.reactiveprogramming.people.domain.usecase;

import com.reactiveprogramming.people.domain.api.IPersonServicePort;
import com.reactiveprogramming.people.domain.model.PersonModel;
import com.reactiveprogramming.people.domain.spi.IPersonPersistencePort;

import reactor.core.publisher.Mono;


public class PeopleUseCase implements IPersonServicePort {

    private final IPersonPersistencePort persistencePort;

    public PeopleUseCase(IPersonPersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }


    @Override
    public void savePeople(PersonModel peopleModel) {
        persistencePort.savePeople(peopleModel);
    }

    @Override
    public Mono<PersonModel> findPeopleByEmail(String email) {
        return persistencePort.findPeopleByEmail(email);
    }
    
}
