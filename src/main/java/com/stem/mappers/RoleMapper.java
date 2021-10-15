package com.stem.mappers;

import com.stem.models.RoleEntity;
import com.stem.models.RoleRequest;
import com.stem.models.RoleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface RoleMapper {

    RoleEntity toEntity(RoleRequest request);

    RoleEntity toEntity(RoleRequest request, @MappingTarget RoleEntity targetEntity);

    RoleResponse toResponse(RoleEntity entity);

    RoleRequest toRequest(RoleEntity entity);

}
