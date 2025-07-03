package io.github.Guimaraes131.watchlistapi.service;

import io.github.Guimaraes131.watchlistapi.model.Media;
import io.github.Guimaraes131.watchlistapi.repository.MediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MediaService {

    private final MediaRepository repository;

    public void create(Media media) {
        repository.save(media);
    }

    public Optional<Media> get(UUID id) {
        return repository.findById(id);
    }

    public void destroy(UUID id) {
        repository.deleteById(id);
    }
}
