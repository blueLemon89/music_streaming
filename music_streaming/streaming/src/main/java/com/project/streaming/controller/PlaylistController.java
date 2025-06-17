package com.project.streaming.controller;

import com.project.streaming.entity.PlaylistEntity;
import com.project.streaming.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController("/playlist")
public class PlaylistController {
    private final PlaylistService playlistService;

    @GetMapping
    public List<PlaylistEntity> getAllPlaylists() {
        return playlistService.getAllPlaylists();
    }

    @GetMapping("/{id}")
    public PlaylistEntity getPlaylist(@PathVariable Long id) {
        return playlistService.getPlaylistById(id);
    }

    @PostMapping
    public PlaylistEntity createPlaylist(@RequestBody PlaylistEntity playlist) {
        return playlistService.savePlaylist(playlist);
    }

    @DeleteMapping("/{id}")
    public void deletePlaylist(@PathVariable Long id) {
        playlistService.deletePlaylist(id);
    }
}
