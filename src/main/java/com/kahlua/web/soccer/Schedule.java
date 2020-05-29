package com.kahlua.web.soccer;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name ="schedule")
public class Schedule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(length = 10) @NotNull
    private String scheDate,gubun,homeTeamId,awayTeamId,homeScore,awayScore;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "stadium_id") @NotNull
    private Stadium stadiumOfSchedule;

    @Builder
    public Schedule(String scheDate, String gubun, String homeTeamId, String awayTeamId, String homeScore, String awayScore){
        this.gubun = gubun;
        this.homeScore = homeScore;
        this.homeTeamId = homeTeamId;
        this.awayTeamId = awayTeamId;
        this.awayScore = awayScore;
        this.scheDate = scheDate;
    }

}
