package com.reactiveprogramming.people.infrastructure.out.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "people")
public class PersonEntity {
    @Id
    private String id;
    private String name;
    private String email;
    private int age;    
}
