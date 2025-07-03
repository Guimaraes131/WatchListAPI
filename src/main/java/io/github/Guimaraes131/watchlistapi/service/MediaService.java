package io.github.Guimaraes131.watchlistapi.service;

import io.github.Guimaraes131.watchlistapi.model.Genre;
import io.github.Guimaraes131.watchlistapi.model.Media;
import io.github.Guimaraes131.watchlistapi.model.MediaType;
import io.github.Guimaraes131.watchlistapi.repository.MediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Media> index(MediaType mediaType, Genre genre, Boolean watched, Integer releaseYear) {

        Media media = new Media();

        media.setMediaType(mediaType);
        media.setGenre(genre);
        media.setReleaseYear(releaseYear);
        media.setWatched(watched);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Media> mediaExample = Example.of(media, matcher);

        return repository.findAll(mediaExample);
    }

    public void update(Media media) {
        repository.save(media);
    }
}
