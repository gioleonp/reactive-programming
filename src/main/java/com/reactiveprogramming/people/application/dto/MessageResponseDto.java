package com.reactiveprogramming.people.application.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponseDto {
    private String id;
    private String message;
    private String idUser;
    private LocalDateTime date;
}
