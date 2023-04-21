package com.reactiveprogramming.people.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.reactiveprogramming.people.application.dto.PersonResponseDto;
import com.reactiveprogramming.people.domain.model.PersonModel;

@Mapper(componentModel = "spring",
  unmappedSourcePolicy = ReportingPolicy.IGNORE,
  unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IPersonResponseDtoMapper {
    
    PersonResponseDto toResponseDto(PersonModel personModel);
    List<PersonResponseDto> toResposeDtoList(List<PersonModel> personModelList); 
}
