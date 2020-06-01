package com.kahlua.web.movie;

import lombok.Data;
import org.springframework.stereotype.Component;
@Data
@Component
public class MovieDTO {
    private String title,  seq,  rankDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getRankDate() {
        return rankDate;
    }

    public void setRankDate(String rankDate) {
        this.rankDate = rankDate;
    }
}
