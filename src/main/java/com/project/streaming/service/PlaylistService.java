package com.project.streaming.service;

import com.project.streaming.entity.PlaylistEntity;

import java.util.List;

public interface PlaylistService {

    List<PlaylistEntity> getAllPlaylists();
    PlaylistEntity getPlaylistById(Long id);
    PlaylistEntity savePlaylist(PlaylistEntity playlist);
    void deletePlaylist(Long id);
}
