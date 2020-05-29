package com.kahlua.web.movie;

import lombok.Builder;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component @Entity
public class Movie {
    public Movie(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long MovieNo;

    @Column(length = 100, nullable = false)
    private String title,seq;

    @Column(length = 15, nullable = false)
    private String rankDate;

    @Builder
    public Movie(String title, String seq, String rankDate){
        this.title = title;
        this.seq = seq;
        this.rankDate = rankDate;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public Long getMovieNo() {
        return MovieNo;
    }

    public void setMovieNo(Long movieNo) {
        MovieNo = movieNo;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRankDate() {
        return rankDate;
    }

    public void setRankDate(String rankDate) {
        this.rankDate = rankDate;
    }
}
