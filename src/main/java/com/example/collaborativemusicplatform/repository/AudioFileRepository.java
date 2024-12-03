package com.example.collaborativemusicplatform.repository;

import com.example.collaborativemusicplatform.model.AudioFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudioFileRepository extends JpaRepository<AudioFile, Long> {
}
