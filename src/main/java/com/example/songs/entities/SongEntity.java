package com.example.songs.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "SONG")
@Getter
@Setter
public class SongEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String artist;

    @Column
    private String album;

    @Column
    private String YTUrl;
}
