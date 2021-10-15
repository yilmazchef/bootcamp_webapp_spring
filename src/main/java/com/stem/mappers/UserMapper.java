package com.stem.mappers;

import com.stem.models.UserEntity;
import com.stem.models.UserRequest;
import com.stem.models.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface UserMapper {

    UserEntity toEntity(UserRequest request);

    UserEntity toEntity(UserRequest request, @MappingTarget UserEntity targetEntity);

    UserResponse toResponse(UserEntity entity);

    UserRequest toRequest(UserEntity entity);

}
