package com.gelinski.apiBtgChallenge.mapper;

import com.gelinski.apiBtgChallenge.data.dto.v1.TransactionDTOV1;
import com.gelinski.apiBtgChallenge.models.TransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    TransactionDTOV1 entityToDTO(TransactionEntity transactionEntity);

    @Mapping(target = "id", ignore = true)
    TransactionEntity dtoToEntity(TransactionDTOV1 transactionDTO);

    List<TransactionDTOV1> mapToDTO(List<TransactionEntity> transactionEntities);
    List<TransactionEntity> mapToEntity(List<TransactionDTOV1> transactionDTOs);
}


