package com.kahlua.web.music;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity(name="music") @Component
@AllArgsConstructor
@NoArgsConstructor
public class Music {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long musicNo;
    @Column(length = 100, nullable = false)
    private String seq;
    @Column(length = 100, nullable = false)
    private String title;
    @Column(length = 100, nullable = false)
    private String artists;
    @Column(length = 300, nullable = false)
    private String thumbnail;

    @Builder
    public Music(String seq, String title, String artists, String thumbnail) {
        this.seq = seq;
        this.title = title;
        this.artists = artists;
        this.thumbnail = thumbnail;
    }

}
