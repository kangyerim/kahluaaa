package com.kahlua.web.soccer;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name ="team")
public class Team {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(length = 10) @NotNull
    private String teamId,regionName,origYyyy,zipCode1,zipCode2,ddd,tel,fax,owner;

    @Column(length = 80) @NotNull
    private String teamName,eTeamName,address,homepage;

    @OneToMany(mappedBy = "teamOfPlayer")
    private List<Player> players;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="stadium_id")
    private Stadium stadiumOfTeam;

    @Builder
    public Team(String regionName, String origYyyy, String zipCode1, String zipCode2, String ddd, String tel, String fax, String owner, String teamName, String eTeamName,String homepage ,String address){
        this.regionName = regionName;
        this.origYyyy = origYyyy;
        this.zipCode1 = zipCode1;
        this.zipCode2 = zipCode2;
        this.ddd = ddd;
        this.tel = tel;
        this.fax = fax;
        this.owner = owner;
        this.teamName = teamName;
        this.eTeamName = eTeamName;
        this.address= address;
        this.homepage= homepage;
    }
}
