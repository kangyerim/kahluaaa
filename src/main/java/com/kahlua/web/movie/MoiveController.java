package com.kahlua.web.movie;

import com.kahlua.web.mappers.MovieMapper;
import com.kahlua.web.proxy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

@RestController
@RequestMapping("/movies")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MoiveController{
    @Autowired Pager pager;
    @Autowired MovieMapper movieMapper;
    @Autowired Proxy pxy;
    @Autowired Box<Object> box;

    @GetMapping("/{searchWord}/{pageNumber}")
    public Map<?,?> list(@PathVariable("pageNumber") String pageNumber,
                         @PathVariable("searchWord") String searchWord){
        if(searchWord.equals("null")){
            pxy.print("검색어 없음");
            pager.setSearchWord("");
        } else {
            pxy.print("검색어는 : "+searchWord);
            pager.setSearchWord(searchWord);
        }
        pxy.print("넘어온 페이지 번호  : "+pageNumber);
        pager.setPageNow(pxy.integer(pageNumber));
        pager.setBlockSize(5);
        pager.setPageSize(5);
        pager.paging();
        Function<Pager, List<MovieDTO>> f = p -> movieMapper.selectMovies(p);
        List<MovieDTO> l = f.apply(pager);
        for(MovieDTO m : l){
            pxy.print(m.toString());
        }
        box.clear();
        box.put("pager", pager);
        box.put("list", l);
        return box.get();
    }

    @GetMapping("/{searchWord}")
    public MovieDTO findOne(@PathVariable String searchWord){
        return movieMapper.selectMovie(searchWord);
    }
}
