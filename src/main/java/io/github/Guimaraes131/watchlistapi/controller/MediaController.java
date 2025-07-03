package io.github.Guimaraes131.watchlistapi.controller;

import io.github.Guimaraes131.watchlistapi.controller.dto.GetMediaDTO;
import io.github.Guimaraes131.watchlistapi.controller.dto.PostMediaDTO;
import io.github.Guimaraes131.watchlistapi.controller.mappers.MediaMapper;
import io.github.Guimaraes131.watchlistapi.model.Media;
import io.github.Guimaraes131.watchlistapi.service.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/media")
@RequiredArgsConstructor
public class MediaController {

    private final MediaService service;
    private final MediaMapper mapper;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PostMediaDTO dto) {
        Media entity = mapper.toEntity(dto);
        service.create(entity);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();

        return ResponseEntity.created(location).build();
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
}
