package com.project.streaming.controller;

import com.project.streaming.entity.ArtistEntity;
import com.project.streaming.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
@RequiredArgsConstructor
public class ArtistController {

    private final ArtistService artistService;

    @GetMapping
    public List<ArtistEntity> getAllArtists() {
        return artistService.getAllArtists();
    }

    @GetMapping("/{id}")
    public ArtistEntity getArtist(@PathVariable Long id) {
        return artistService.getArtistById(id);
    }

    @PostMapping
    public ArtistEntity createArtist(@RequestBody ArtistEntity artist) {
        return artistService.saveArtist(artist);
    }

    @DeleteMapping("/{id}")
    public void deleteArtist(@PathVariable Long id) {
        artistService.deleteArtist(id);
    }
}
