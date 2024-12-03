package com.example.collaborativemusicplatform.service;

import com.example.collaborativemusicplatform.model.AudioFile;
import com.example.collaborativemusicplatform.repository.AudioFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class AudioFileService {
    private final AudioFileRepository audioFileRepository;

    public AudioFileService(AudioFileRepository audioFileRepository) {
        this.audioFileRepository = audioFileRepository;
    }

    public AudioFile saveFile(MultipartFile file) throws IOException {
        String uploadDir = "uploads";
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdir();

        String filePath = uploadDir + "/" + file.getOriginalFilename();
        file.transferTo(new File(filePath));

        AudioFile audioFile = new AudioFile();
        audioFile.setFileName(file.getOriginalFilename());
        audioFile.setFilePath(filePath);
        return audioFileRepository.save(audioFile);
    }

    public Resource getFile(Long id) {
        AudioFile file = audioFileRepository.findById(id).orElseThrow();
        return new FileSystemResource(file.getFilePath());
    }

    public List<AudioFile> listFiles() {
        return audioFileRepository.findAll();
    }
}
