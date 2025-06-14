package com.project.streaming.song;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.streaming.entity.SongEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SongControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void createAndFetchSong() throws Exception {
//        SongEntity songEntity = new SongEntity(null, "Test Song", "Artist");
//        String json = objectMapper.writeValueAsString(songEntity);
//
//        String location = mockMvc.perform(post("/songs")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(json))
//                .andExpect(status().isCreated())
//                .andReturn().getResponse().getHeader("Location");
//
//        mockMvc.perform(get(location))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.title").value("Test Song"))
//                .andExpect(jsonPath("$.artist").value("Artist"));
    }
}
