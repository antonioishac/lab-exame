package br.com.labexame.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.com.labexame.domain.Usuario;
import br.com.labexame.service.dto.UsuarioDTO;

@Mapper(componentModel="spring", uses= {})
public interface UsuarioMapper extends EntityMapper<UsuarioDTO, Usuario> {

	@Mappings({
        @Mapping(source = "id", target = "codigo"),
	})
	@Override
	UsuarioDTO toDto(Usuario entity);

	@Mappings({
        @Mapping(source = "codigo", target = "id"),
	})
	@Override
	Usuario toEntity(UsuarioDTO dto);

}
