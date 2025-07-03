package io.github.Guimaraes131.watchlistapi.repository;

import io.github.Guimaraes131.watchlistapi.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MediaRepository extends JpaRepository<Media, UUID> {
}
