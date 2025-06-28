package com.project.streaming.controller;

import com.project.streaming.entity.SongEntity;
import com.project.streaming.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;

    @GetMapping
    public List<SongEntity> listSongs() {
        return songService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createSong(@RequestBody SongEntity songEntity) {
        songService.save(songEntity);
        return ResponseEntity.ok("Save song successfully");
    }

    @PostMapping("/batch")
    public ResponseEntity<List<SongEntity>> saveAllSongs(@RequestBody List<SongEntity> songs) {
        List<SongEntity> savedSongs = songService.saveAll(songs);
        return ResponseEntity.ok(savedSongs);
    }


    @GetMapping("/{id}")
    public ResponseEntity<SongEntity> getSong(@PathVariable Long id) {
        SongEntity songEntity = songService.findById(id);
        if (songEntity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(songEntity);
    }

    @GetMapping("/search")
    public ResponseEntity<List<SongEntity>> searchSong(@RequestParam("keyword") String keyword) {
        return ResponseEntity.ok(songService.searchSong(keyword));
    }
}
