package com.reactiveprogramming.people.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonModel {
    private String id;
    private String name;
    private String email;
    private int age;
}
