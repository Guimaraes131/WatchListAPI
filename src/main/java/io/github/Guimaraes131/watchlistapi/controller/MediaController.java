package io.github.Guimaraes131.watchlistapi.controller;

import io.github.Guimaraes131.watchlistapi.controller.dto.GetMediaDTO;
import io.github.Guimaraes131.watchlistapi.controller.dto.PostMediaDTO;
import io.github.Guimaraes131.watchlistapi.controller.mappers.MediaMapper;
import io.github.Guimaraes131.watchlistapi.model.Genre;
import io.github.Guimaraes131.watchlistapi.model.Media;
import io.github.Guimaraes131.watchlistapi.model.MediaType;
import io.github.Guimaraes131.watchlistapi.service.MediaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/media")
@RequiredArgsConstructor
public class MediaController implements GenericController {

    private final MediaService service;
    private final MediaMapper mapper;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid PostMediaDTO dto) {
        Media entity = mapper.toEntity(dto);

        service.create(entity);

        return ResponseEntity.created(generateLocationHeader(entity.getId())).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);

        return service.get(uuid)
                .map(media -> {
                    GetMediaDTO dto = mapper.toDTO(media);

                    return ResponseEntity.ok(dto);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> destroy(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        service.destroy(uuid);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<GetMediaDTO>> index(
            @RequestParam(required = false, value = "mediaType") MediaType mediaType,
            @RequestParam(required = false, value = "genre") Genre genre,
            @RequestParam(required = false, value = "watched") Boolean watched,
            @RequestParam(required = false, value = "releaseYear") Integer releaseYear
    ) {

        List<Media> mediaList = service.index(mediaType, genre, watched, releaseYear);

        List<GetMediaDTO> dtos = mediaList.stream()
                .map(mapper::toDTO)
                .toList();

        return ResponseEntity.ok(dtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody @Valid PostMediaDTO dto) {
        UUID uuid = UUID.fromString(id);

        return service.get(uuid)
                .map(entity -> {
                    mapper.updateFromDTO(dto, entity);
                    service.update(entity);

                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
