package io.github.Guimaraes131.watchlistapi.controller.mappers;

import io.github.Guimaraes131.watchlistapi.controller.dto.GetMediaDTO;
import io.github.Guimaraes131.watchlistapi.controller.dto.PostMediaDTO;
import io.github.Guimaraes131.watchlistapi.model.Media;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MediaMapper  {

    Media toEntity(PostMediaDTO dto);

    GetMediaDTO toDTO(Media media);

    @Mapping(target = "id", ignore = true)
    void updateFromDTO(PostMediaDTO dto, @MappingTarget Media entity);
}
