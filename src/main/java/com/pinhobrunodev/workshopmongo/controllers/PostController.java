package com.pinhobrunodev.workshopmongo.controllers;

import com.pinhobrunodev.workshopmongo.models.dto.PostDTO;
import com.pinhobrunodev.workshopmongo.services.PostService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService service;


    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO> byId(@PathVariable String id){
        return ResponseEntity.ok().body(service.byID(id));
    }
    @GetMapping(value="/fullsearch")
    public ResponseEntity<List<PostDTO>> fullSearch(
            @RequestParam(value="text", defaultValue="") String text,
            @RequestParam(value="start", defaultValue="") String start,
            @RequestParam(value="end", defaultValue="") String end) {
        List<PostDTO> list = service.fullSearch(text, start, end);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<PostDTO>> byTitle(@RequestParam(value = "text",defaultValue = "") String text){
        return ResponseEntity.ok().body(service.byTitle(text));
    }

}
