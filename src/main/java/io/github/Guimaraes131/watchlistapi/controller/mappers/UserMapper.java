package io.github.Guimaraes131.watchlistapi.controller.mappers;

import io.github.Guimaraes131.watchlistapi.controller.dto.PostUserDTO;
import io.github.Guimaraes131.watchlistapi.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(PostUserDTO dto);
}
