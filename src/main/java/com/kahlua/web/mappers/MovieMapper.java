package com.kahlua.web.mappers;

import com.kahlua.web.movie.MovieDTO;
import com.kahlua.web.proxy.Pager;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieMapper {
    public void insertMovie();
    public int count();
    public List<MovieDTO> selectMovies(Pager pager);
}
