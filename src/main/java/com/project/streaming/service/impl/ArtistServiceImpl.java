package com.project.streaming.service.impl;

import com.project.streaming.entity.ArtistEntity;
import com.project.streaming.exception.ResourceNotFound;
import com.project.streaming.repo.ArtistRepository;
import com.project.streaming.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    @Override
    public List<ArtistEntity> getAllArtists() {
        return artistRepository.findAll();
    }

    @Override
    public ArtistEntity getArtistById(Long id) {
        return artistRepository.findById(id).orElseThrow(() ->
                new ResourceNotFound("Artist not found with ID: " + id));
    }

    @Override
    public ArtistEntity saveArtist(ArtistEntity artist) {
        return artistRepository.save(artist);
    }

    @Override
    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }
}
