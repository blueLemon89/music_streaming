package com.project.streaming.service.impl;

import com.project.streaming.entity.SongEntity;
import com.project.streaming.exception.ResourceNotFound;
import com.project.streaming.repo.SongRepository;
import com.project.streaming.service.SongService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    @Override
    public List<SongEntity> findAll() {
        return songRepository.findAll();
    }

    @Override
    @Transactional
    public void save(SongEntity songEntity) {
        songRepository.save(songEntity);
    }

    @Override
    @Transactional
    public List<SongEntity> saveAll(List<SongEntity> songs) {
        return songRepository.saveAll(songs);
    }


    @Override
    public SongEntity findById(Long id) {
        return songRepository.findById(id).orElseThrow(() ->
                new ResourceNotFound("Song not found with ID: " + id));
    }

    @Override
    public List<SongEntity> searchSong(String keyword) {
        return songRepository.searchByKeyword(keyword);
    }
}
