package com.kahlua.web.soccer;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name ="stadium")
public class Stadium {
    public Stadium(){}
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(length = 10) @NotNull
    private String stadiumId, stadiumName,hometeamId,seatCount,ddd,tel;
    @Column(length = 60) @NotNull
    private String address;

    @OneToMany(mappedBy = "stadiumOfTeam")
    private List<Team> teams;

    @OneToMany(mappedBy = "stadiumOfSchedule")
    private List<Schedule> schedules;

    @Builder
    public Stadium( String stadiumName, String hometeamId, String seatCount, String ddd, String tel, String address){
        this.address = address;
        this.ddd = ddd;
        this.hometeamId = hometeamId;
        this.seatCount = seatCount;
        this.stadiumName = stadiumName;
        this.tel = tel;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(String stadiumId) {
        this.stadiumId = stadiumId;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public String getHometeamId() {
        return hometeamId;
    }

    public void setHometeamId(String hometeamId) {
        this.hometeamId = hometeamId;
    }

    public String getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(String seatCount) {
        this.seatCount = seatCount;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}
