package com.project.streaming.song;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public List<Song> listSongs() {
        return songService.findAll();
    }

    @PostMapping
    public ResponseEntity<Song> createSong(@RequestBody Song song) {
        Song created = songService.save(song);
        return ResponseEntity.created(URI.create("/songs/" + created.getId())).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSong(@PathVariable Long id) {
        Song song = songService.findById(id);
        if (song == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(song);
    }
}
