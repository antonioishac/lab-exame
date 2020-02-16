package br.com.labexame.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.com.labexame.domain.Prestador;
import br.com.labexame.service.dto.PrestadorDTO;

@Mapper(componentModel="spring", uses= { OperadoraMapper.class, UsuarioMapper.class })
public interface PrestadorMapper extends EntityMapper<PrestadorDTO, Prestador> {

	@Mappings({
        @Mapping(source = "id.cnpjCpf", target = "cnpjCpf")
	})
	@Override
	PrestadorDTO toDto(Prestador entity);

	@Mappings({
        @Mapping(source = "operadora.codigo", target = "id.codigoOperadora"),
        @Mapping(source = "cnpjCpf", target = "id.cnpjCpf")
	})
	@Override
	Prestador toEntity(PrestadorDTO dto);

}
