package com.example.collaborativemusicplatform.controller;

import com.example.collaborativemusicplatform.model.AudioFile;
import com.example.collaborativemusicplatform.service.AudioFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/audio")
public class AudioFileController {
    private final AudioFileService audioFileService;

    public AudioFileController(AudioFileService audioFileService) {
        this.audioFileService = audioFileService;
    }

    @PostMapping("/upload")
    public ResponseEntity<AudioFile> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            AudioFile savedFile = audioFileService.saveFile(file);
            return ResponseEntity.ok(savedFile);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getFile(@PathVariable Long id) {
        Resource file = audioFileService.getFile(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @GetMapping
    public ResponseEntity<List<AudioFile>> listFiles() {
        return ResponseEntity.ok(audioFileService.listFiles());
    }
}
