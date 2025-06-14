package com.project.streaming.service;

import com.project.streaming.entity.SongEntity;

import java.util.List;

public interface SongService {

    public List<SongEntity> findAll() ;

    public void save(SongEntity songEntity);

    public SongEntity findById(Long id);

    List<SongEntity> saveAll(List<SongEntity> songs);

}
