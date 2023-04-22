package com.reactiveprogramming.people.infrastructure.out.persistence.entity;

import java.time.LocalDateTime;
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
@Document("messages")
public class MessageEntity {

  @Id
  private String id;

  private String message;
  private String idUser;
  private LocalDateTime date;
}
