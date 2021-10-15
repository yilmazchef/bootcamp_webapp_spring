package com.stem.mappers;

import com.stem.models.RoleEntity;
import com.stem.models.RoleRequest;
import com.stem.models.RoleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface RoleMapper {

    RoleEntity toEntity(RoleRequest request);

    RoleResponse toResponse(RoleEntity entity);


}
