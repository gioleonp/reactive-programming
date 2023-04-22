package com.reactiveprogramming.people.infrastructure.out.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.reactiveprogramming.people.domain.model.MessageModel;
import com.reactiveprogramming.people.infrastructure.out.persistence.entity.MessageEntity;

@Mapper(componentModel = "spring",
  unmappedSourcePolicy = ReportingPolicy.IGNORE,
  unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IMessageEntityMapper {
    
    MessageModel toModel(MessageEntity messageEntity);
    MessageEntity toEntity(MessageModel messageModel);
    List<MessageModel> toMessageModelList(List<MessageEntity> messageEntityList);
    List<MessageEntity> toMessageEntityList(List<MessageEntity> messageModelList);
}
