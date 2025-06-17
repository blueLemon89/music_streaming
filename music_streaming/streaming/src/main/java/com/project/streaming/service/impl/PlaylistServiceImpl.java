package com.project.streaming.service.impl;

import com.project.streaming.entity.PlaylistEntity;
import com.project.streaming.exception.ResourceNotFound;
import com.project.streaming.repo.PlaylistRepository;
import com.project.streaming.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;

    @Override
    public List<PlaylistEntity> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    @Override
    public PlaylistEntity getPlaylistById(Long id) {
        return playlistRepository.findById(id).orElseThrow(() ->
                new ResourceNotFound("Playlist not found with ID: " + id));
    }

    @Override
    public PlaylistEntity savePlaylist(PlaylistEntity playlist) {
        return playlistRepository.save(playlist);
    }

    @Override
    public void deletePlaylist(Long id) {
        playlistRepository.deleteById(id);
    }
}
