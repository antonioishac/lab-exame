package br.com.labexame.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.com.labexame.domain.Operadora;
import br.com.labexame.service.dto.OperadoraDTO;

@Mapper(componentModel="spring", uses= {})
public interface OperadoraMapper extends EntityMapper<OperadoraDTO, Operadora> {

	@Mappings({
        @Mapping(source = "id", target = "codigo"),
	})
	@Override
	OperadoraDTO toDto(Operadora entity);

	@Mappings({
        @Mapping(source = "codigo", target = "id"),
	})
	@Override
	Operadora toEntity(OperadoraDTO dto);

}
