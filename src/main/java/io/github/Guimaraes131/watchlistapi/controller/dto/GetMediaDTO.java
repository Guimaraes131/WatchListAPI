package io.github.Guimaraes131.watchlistapi.controller.dto;

import io.github.Guimaraes131.watchlistapi.model.Genre;
import io.github.Guimaraes131.watchlistapi.model.MediaType;

import java.util.UUID;

public record GetMediaDTO(
        UUID id,
        String title,
        MediaType mediaType,
        Integer releaseYear,
        Integer duration,
        Boolean watched,
        Genre genre
) {
}
