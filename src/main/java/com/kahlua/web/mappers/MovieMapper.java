package com.kahlua.web.mappers;

import org.springframework.stereotype.Repository;

@Repository
public interface MovieMapper {
    public void insertMovie();

    public int count();
}
