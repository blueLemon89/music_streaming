package com.project.streaming.service;

import com.project.streaming.entity.ArtistEntity;

import java.util.List;

public interface ArtistService {
    List<ArtistEntity> getAllArtists();
    ArtistEntity getArtistById(Long id);
    ArtistEntity saveArtist(ArtistEntity artist);
    void deleteArtist(Long id);
}
