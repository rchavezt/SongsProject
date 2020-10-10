package com.example.songs.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/song")
public class SongsController {

    @RequestMapping(value = "/1", method = RequestMethod.GET)
    public String getSong(){
        return "In the shadows";
    }
}
