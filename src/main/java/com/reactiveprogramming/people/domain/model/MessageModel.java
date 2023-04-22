package com.reactiveprogramming.people.domain.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageModel {

  private String id;
  private String message;
  private String idUser;
  private LocalDateTime date;
}
