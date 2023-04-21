package com.reactiveprogramming.people.infrastructure.out.persistence.mapper;

import com.reactiveprogramming.people.domain.model.PersonModel;
import com.reactiveprogramming.people.infrastructure.out.persistence.entity.PersonEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
  componentModel = "spring",
  unmappedSourcePolicy = ReportingPolicy.IGNORE,
  unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IPersonEntityMapper {
  PersonModel toModel(PersonEntity peopleEntity);

  PersonEntity toEntity(PersonModel peopleModel);

  List<PersonModel> toModelList(List<PersonEntity> peopleEntityList);

  List<PersonEntity> toEntityList(List<PersonModel> peopleModelList);
}
