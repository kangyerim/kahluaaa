package com.kahlua.web.movie;

import com.kahlua.web.mappers.MovieMapper;
import com.kahlua.web.proxy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movie")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MoiveController{
    @Autowired Pager pager;
    @Autowired MovieMapper movieMapper;
    @Autowired Proxy pxy;
    @Autowired Box<Object> box;

    @GetMapping("/list/{pageNumber}/{searchWord}")
    public Map<?,?> list(@PathVariable("pageNumber") String pageNumber,
                         @PathVariable("searchWord") String searchWord){
        if(searchWord.equals("")){
            pxy.print("검색어 없음");
        } else {pxy.print("검색어는 : "+searchWord);}
        pager.setPageNow(pxy.integer(pageNumber));
        pager.setBlockSize(5);
        pager.setPageSize(5);
        IFunction<Pager, List<MovieDTO>> f = p -> movieMapper.selectMovies(p);
        List<MovieDTO> l = f.apply(pager);
        pxy.print("*******");
        for(MovieDTO m : l){
            pxy.print(m.toString());
        }
        box.clear();
        box.put("count",l.size());
        box.put("list", l);
        return box.get();
    }
}
