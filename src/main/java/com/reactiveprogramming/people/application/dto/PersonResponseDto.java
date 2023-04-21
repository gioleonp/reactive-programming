package com.reactiveprogramming.people.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonResponseDto {
  private String id;
  private String name;
  private String email;
  private int age;
}
