package com.kahlua.web.player;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "playered")
public class Playered {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long player_id;
    @Column(length = 30, nullable = false)
    private String player_name;
    @Column(length = 30, nullable = false)
    private String position;
    @Column(length = 30, nullable = false)
    private String back_no;
    @Column(length = 30, nullable = false)
    private String team_id;

    @Builder
    public Playered( String player_name, String back_no, String team_id) {
        this.player_name = player_name;
        this.back_no = back_no;
        this.team_id = team_id;
    }
}
