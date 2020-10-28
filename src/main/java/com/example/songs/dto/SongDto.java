package com.example.songs.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SongDto {
    private Long id;
    private String name;
    private String artist;
    private String album;
    private String YTUrl;
}

