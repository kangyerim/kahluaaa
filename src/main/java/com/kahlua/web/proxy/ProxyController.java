package com.kahlua.web.proxy;

import com.kahlua.web.movie.Movie;
import com.kahlua.web.movie.MovieRepository;
import com.kahlua.web.music.Music;
import com.kahlua.web.music.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RestController
public class ProxyController{
    @Autowired Box<Object> box;
    @Autowired Crawler crawler;
    @Autowired Proxy pxy;
    @Autowired FileUploader loader;
    @Autowired MusicRepository musicRepository;
    @Autowired MovieRepository movieRepository;

    @PostMapping("/bugsmusic")
    public HashMap<String,Object> bugsmusic(@RequestBody String searchWord) {
        box.clear();
        if(musicRepository.count() == 0) crawler.bugsMusic();
        List<Music> chart =  musicRepository.findAll();
        box.put("list",chart);
        pxy.print("count : "+chart.size());
        box.put("count",chart.size());
        return box.get();
    }
    @GetMapping("/soccer/{searchWord}")
    public HashMap<String, Object> soccer(@PathVariable String searchWord) {
        pxy.print("넘어온 키워드 " + searchWord);
        loader.upload();
        return null;
    }
    @GetMapping("/movie/{searchWord}")
    public HashMap<String, Object> movie(@PathVariable String searchWord){
        pxy.print("넘어온 키워드 : " + searchWord);
        box.clear();
        if(movieRepository.count() == 0) crawler.movieChart();
        List<Movie> chart = movieRepository.findAll();
        box.put("list",chart);
        box.put("count",chart.size());
        return box.get();
    }
}