package com.project.streaming.song;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class SongService {

    private final Map<Long, Song> songs = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public List<Song> findAll() {
        return new ArrayList<>(songs.values());
    }

    public Song save(Song song) {
        long id = idGenerator.incrementAndGet();
        song.setId(id);
        songs.put(id, song);
        return song;
    }

    public Song findById(Long id) {
        return songs.get(id);
    }
}
