package com.kahlua.web.music;

import com.kahlua.web.proxy.Box;
import com.kahlua.web.proxy.IFunction;
import com.kahlua.web.proxy.Pager;
import com.kahlua.web.proxy.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/musics")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MusicController {
    @Autowired Proxy pxy;
    @Autowired Pager pager;
    @Autowired Box<Object> box;
    @Autowired MusicRepository musicRepository;

    @GetMapping("/{searchWord}/{pageNumber}")
    public Map<?,?> chart(@PathVariable("searchWord") String searchWord,
                          @PathVariable("pageNumber") String pageNumber){
        if(searchWord.equals("")){
            pxy.print("no searchWord");
        } else {pxy.print("검색어는 "+ searchWord);}
        pager.setPageNow(pxy.integer(pageNumber));
        pager.setBlockSize(5);
        pager.setPageSize(5);
        pager.paging();
        IFunction<Pager, List<Music>> f = p -> musicRepository.findAll();
        List<Music> list = f.apply(pager);
        for(Music m : list) {
            pxy.print(m.toString());
        }
        box.clear();
        box.put("pager", pager);
        box.put("list", list);
        return box.get();
    }
}
