package com.project.streaming.repo;

import com.project.streaming.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<SongEntity, Long> {

    @Query(value = "SELECT * FROM songs s " +
            "WHERE LOWER(s.title) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(s.album) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(s.artist) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR CAST(s.duration AS TEXT) LIKE CONCAT('%', :keyword, '%') " +
            "OR TO_CHAR(s.created_at, 'YYYY-MM-DD HH24:MI:SS') LIKE CONCAT('%', :keyword, '%')",
            nativeQuery = true)
    List<SongEntity> searchByKeyword(String keyword);
}
