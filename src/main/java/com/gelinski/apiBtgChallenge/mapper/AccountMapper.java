package com.gelinski.apiBtgChallenge.mapper;

import com.gelinski.apiBtgChallenge.data.dto.v1.AccountDTOV1;
import com.gelinski.apiBtgChallenge.models.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDTOV1 entityToDTO(AccountEntity accountEntity);

    @Mapping(target = "id", ignore = true)
    AccountEntity dtoToEntity(AccountDTOV1 accountDTO);

    List<AccountDTOV1> mapToDTO(List<AccountEntity> accountEntities);

    List<AccountEntity> mapToEntity(List<AccountDTOV1> accountDTOs);
}
