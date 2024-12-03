package com.example.collaborativemusicplatform.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "audio_files")
public class AudioFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String filePath;
}
