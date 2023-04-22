package com.reactiveprogramming.people.application.mapper;

import com.reactiveprogramming.people.application.dto.MessageRequestDto;
import com.reactiveprogramming.people.domain.model.MessageModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
  componentModel = "spring",
  unmappedSourcePolicy = ReportingPolicy.IGNORE,
  unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IMessageRequestDtoMapper {
  MessageModel toModel(MessageRequestDto messageRequestDto);
}
