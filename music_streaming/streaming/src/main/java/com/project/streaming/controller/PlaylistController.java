package com.project.streaming.controller;

import com.project.streaming.entity.PlaylistEntity;
import com.project.streaming.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/playlist")
public class PlaylistController {
    private final PlaylistService playlistService;

    @GetMapping
    public ResponseEntity<List<PlaylistEntity>> getAllPlaylists() {
        return ResponseEntity.ok(playlistService.getAllPlaylists());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaylistEntity> getPlaylist(@PathVariable Long id) {
        return ResponseEntity.ok(playlistService.getPlaylistById(id));
    }

    @PostMapping
    public ResponseEntity<PlaylistEntity> createPlaylist(@RequestBody PlaylistEntity playlist) {
        return ResponseEntity.ok(playlistService.savePlaylist(playlist));
    }

    @DeleteMapping("/{id}")
    public void deletePlaylist(@PathVariable Long id) {
        playlistService.deletePlaylist(id);
    }
}
