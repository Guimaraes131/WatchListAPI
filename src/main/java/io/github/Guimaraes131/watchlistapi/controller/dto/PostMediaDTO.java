package io.github.Guimaraes131.watchlistapi.controller.dto;

import io.github.Guimaraes131.watchlistapi.model.Genre;
import io.github.Guimaraes131.watchlistapi.model.MediaType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PostMediaDTO(
        @NotBlank(message = "field cannot be blank or null.")
        @Size(min = 1, max = 100, message = "size needs to be between 1 and 100")
        String title,

        @NotNull(message = "field cannot be null.")
        MediaType mediaType,

        @NotNull(message = "field cannot be null.")
        Integer releaseYear,

        @NotNull(message = "field cannot be null.")
        Integer duration,

        Boolean watched,

        @NotNull(message = "field cannot be null.")
        Genre genre
) {}
