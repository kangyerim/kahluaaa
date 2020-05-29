package com.kahlua.web.soccer;

import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@AllArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity(name="player")
@Lazy
public class Player {
    public Player(){}
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(length = 30)
    private String playerId,playerName;
    @Column(length = 40)
    private String ePlayerName;
    @Column(length = 20)
    private String nickName,joinYyyy,position,backNo,nation,birthDate,solar;
    @Column(length = 10)
    private String height,weight;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "team_id")
    private Team teamOfPlayer;

    @Builder
    public Player(String playerId,String nickName,String playerName, String ePlayerName, String joinYyyy, String position, String backNo, String nation, String birthDate, String solar, String height, String weight){
        this.playerId = playerId;
        this.playerName = playerName;
        this.ePlayerName = ePlayerName;
        this.nickName = nickName;
        this.joinYyyy = joinYyyy;
        this.position = position;
        this.backNo = backNo;
        this.nation = nation;
        this.birthDate = birthDate;
        this.solar = solar;
        this.height = height;
        this.weight = weight;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getePlayerName() {
        return ePlayerName;
    }

    public void setePlayerName(String ePlayerName) {
        this.ePlayerName = ePlayerName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getJoinYyyy() {
        return joinYyyy;
    }

    public void setJoinYyyy(String joinYyyy) {
        this.joinYyyy = joinYyyy;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBackNo() {
        return backNo;
    }

    public void setBackNo(String backNo) {
        this.backNo = backNo;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getSolar() {
        return solar;
    }

    public void setSolar(String solar) {
        this.solar = solar;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Team getTeam() {
        return teamOfPlayer;
    }

    public void setTeam(Team team) {
        this.teamOfPlayer = team;
    }

    @Override
    public String toString() {
        return "Player{" +
                "no=" + no +
                ", playerId='" + playerId + '\'' +
                ", playerName='" + playerName + '\'' +
                ", ePlayerName='" + ePlayerName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", joinYyyy='" + joinYyyy + '\'' +
                ", position='" + position + '\'' +
                ", backNo='" + backNo + '\'' +
                ", nation='" + nation + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", solar='" + solar + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", teamOfPlayer=" + teamOfPlayer +
                '}';
    }
}
