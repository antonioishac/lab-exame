package br.com.labexame.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.com.labexame.domain.Estipulante;
import br.com.labexame.service.dto.EstipulanteDTO;

@Mapper(componentModel="spring", uses= { OperadoraMapper.class })
public interface EstipulanteMapper extends EntityMapper<EstipulanteDTO, Estipulante> {

	@Mappings({
        @Mapping(source = "id.codigoEstipulante", target = "codigoEstipulante"),
        //@Mapping(source = "id.codigoOperadora", target = "operadora.codigo"),
	})
	@Override
	EstipulanteDTO toDto(Estipulante entity);

	@Mappings({
		@Mapping(source = "codigoEstipulante", target = "id.codigoEstipulante"),
        @Mapping(source = "operadora.codigo", target = "id.codigoOperadora"),
	})
	@Override
	Estipulante toEntity(EstipulanteDTO dto);

}
