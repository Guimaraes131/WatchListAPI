package io.github.Guimaraes131.watchlistapi.validator;

import io.github.Guimaraes131.watchlistapi.exception.DuplicatedRecordException;
import io.github.Guimaraes131.watchlistapi.model.Media;
import io.github.Guimaraes131.watchlistapi.repository.MediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MediaValidator {

    private final MediaRepository repository;

    public void validate(Media media) {
        if (existsMediaTitle(media)) {
            throw new DuplicatedRecordException("This title is already in use.");
        }
    }

    private boolean existsMediaTitle(Media media) {
        return repository.findByTitle(media.getTitle())
                .map(existing -> media.getId() == null || !media.getId().equals(existing.getId()))
                .orElse(false);
    }
}
