package com.reactiveprogramming.people.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.reactiveprogramming.people.application.dto.PersonRequestDto;
import com.reactiveprogramming.people.domain.model.PersonModel;

@Mapper(componentModel = "spring",
  unmappedSourcePolicy = ReportingPolicy.IGNORE,
  unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IPersonRequestDtoMapper {
    PersonModel toModel(PersonRequestDto personRequestDto);
    List<PersonModel> toModelList(List<PersonRequestDto> personRequestDtos);
}
