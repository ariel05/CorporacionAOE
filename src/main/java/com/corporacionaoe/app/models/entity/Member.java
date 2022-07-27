package com.corporacionaoe.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.corporacionaoe.app.utils.CountryEnum;

@Entity
public class Member implements Serializable{

	private static final long serialVersionUID = 4745556099645794729L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer profileId;
	private Integer steamId;
	private String name;
	@Enumerated(EnumType.STRING)
	private CountryEnum country;
	//RM 1v1
    private Integer rm1v1Rated = 0;
    private Integer rm1v1highestRated = 0;
    private Integer rm1v1Streak = 0;
    private Integer rm1v1NumWin = 0;
    private Integer rm1v1NumLosses = 0;
    private Integer rm1v1AvgRated = 0;
    private Integer rm1v1AvgWin = 0;
    private Integer rm1v1TotalGames = 0;
    //RM 1v1
    private Integer rmTgRated = 0;
    private Integer rmTghighestRated = 0;
    private Integer rmTgStreak = 0;
    private Integer rmTgNumWin = 0;
    private Integer rmTgNumLosses = 0;
    private Integer rmTgAvgRated = 0;
    private Integer rmTgAvgWin = 0;
    private Integer rmTgTotalGames = 0;
    //RM 1v1
    private Integer ew1v1Rated = 0;
    private Integer ew1v1highestRated = 0;
    private Integer ew1v1Streak = 0;
    private Integer ew1v1NumWin = 0;
    private Integer ew1v1NumLosses = 0;
    private Integer ew1v1AvgRated = 0;
    private Integer ew1v1AvgWin = 0;
    private Integer ew1v1TotalGames = 0;
    //RM 1v1
    private Integer ewTgRated = 0;
    private Integer ewTghighestRated = 0;
    private Integer ewTgStreak = 0;
    private Integer ewTgNumWin = 0;
    private Integer ewTgNumLosses = 0;
    private Integer ewTgAvgRated = 0;
    private Integer ewTgAvgWin = 0;
    private Integer ewTgTotalGames = 0;
	
	public Member() {}
	
	public Integer getProfileId() {
		return profileId;
	}
	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}
	public Integer getSteamId() {
		return steamId;
	}
	public void setSteamId(Integer steamId) {
		this.steamId = steamId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CountryEnum getCountry() {
		return country;
	}
	public void setCountry(CountryEnum country) {
		this.country = country;
	}
	public Integer getRm1v1Rated() {
		return rm1v1Rated;
	}
	public void setRm1v1Rated(Integer rm1v1Rated) {
		this.rm1v1Rated = rm1v1Rated;
	}
	public Integer getRm1v1highestRated() {
		return rm1v1highestRated;
	}
	public void setRm1v1highestRated(Integer rm1v1highestRated) {
		this.rm1v1highestRated = rm1v1highestRated;
	}
	public Integer getRm1v1Streak() {
		return rm1v1Streak;
	}
	public void setRm1v1Streak(Integer rm1v1Streak) {
		this.rm1v1Streak = rm1v1Streak;
	}
	public Integer getRm1v1NumWin() {
		return rm1v1NumWin;
	}
	public void setRm1v1NumWin(Integer rm1v1NumWin) {
		this.rm1v1NumWin = rm1v1NumWin;
	}
	public Integer getRm1v1NumLosses() {
		return rm1v1NumLosses;
	}
	public void setRm1v1NumLosses(Integer rm1v1NumLosses) {
		this.rm1v1NumLosses = rm1v1NumLosses;
	}
	public Integer getRm1v1AvgRated() {
		return rm1v1AvgRated;
	}
	public void setRm1v1AvgRated(Integer rm1v1AvgRated) {
		this.rm1v1AvgRated = rm1v1AvgRated;
	}
	public Integer getRm1v1AvgWin() {
		return rm1v1AvgWin;
	}
	public void setRm1v1AvgWin(Integer rm1v1AvgWin) {
		this.rm1v1AvgWin = rm1v1AvgWin;
	}
	public Integer getRmTgRated() {
		return rmTgRated;
	}
	public void setRmTgRated(Integer rmTgRated) {
		this.rmTgRated = rmTgRated;
	}
	public Integer getRmTghighestRated() {
		return rmTghighestRated;
	}
	public void setRmTghighestRated(Integer rmTghighestRated) {
		this.rmTghighestRated = rmTghighestRated;
	}
	public Integer getRmTgStreak() {
		return rmTgStreak;
	}
	public void setRmTgStreak(Integer rmTgStreak) {
		this.rmTgStreak = rmTgStreak;
	}
	public Integer getRmTgNumWin() {
		return rmTgNumWin;
	}
	public void setRmTgNumWin(Integer rmTgNumWin) {
		this.rmTgNumWin = rmTgNumWin;
	}
	public Integer getRmTgNumLosses() {
		return rmTgNumLosses;
	}
	public void setRmTgNumLosses(Integer rmTgNumLosses) {
		this.rmTgNumLosses = rmTgNumLosses;
	}
	public Integer getRmTgAvgRated() {
		return rmTgAvgRated;
	}
	public void setRmTgAvgRated(Integer rmTgAvgRated) {
		this.rmTgAvgRated = rmTgAvgRated;
	}
	public Integer getRmTgAvgWin() {
		return rmTgAvgWin;
	}
	public void setRmTgAvgWin(Integer rmTgAvgWin) {
		this.rmTgAvgWin = rmTgAvgWin;
	}
	public Integer getEw1v1Rated() {
		return ew1v1Rated;
	}
	public void setEw1v1Rated(Integer ew1v1Rated) {
		this.ew1v1Rated = ew1v1Rated;
	}
	public Integer getEw1v1highestRated() {
		return ew1v1highestRated;
	}
	public void setEw1v1highestRated(Integer ew1v1highestRated) {
		this.ew1v1highestRated = ew1v1highestRated;
	}
	public Integer getEw1v1Streak() {
		return ew1v1Streak;
	}
	public void setEw1v1Streak(Integer ew1v1Streak) {
		this.ew1v1Streak = ew1v1Streak;
	}
	public Integer getEw1v1NumWin() {
		return ew1v1NumWin;
	}
	public void setEw1v1NumWin(Integer ew1v1NumWin) {
		this.ew1v1NumWin = ew1v1NumWin;
	}
	public Integer getEw1v1NumLosses() {
		return ew1v1NumLosses;
	}
	public void setEw1v1NumLosses(Integer ew1v1NumLosses) {
		this.ew1v1NumLosses = ew1v1NumLosses;
	}
	public Integer getEw1v1AvgRated() {
		return ew1v1AvgRated;
	}
	public void setEw1v1AvgRated(Integer ew1v1AvgRated) {
		this.ew1v1AvgRated = ew1v1AvgRated;
	}
	public Integer getEw1v1AvgWin() {
		return ew1v1AvgWin;
	}
	public void setEw1v1AvgWin(Integer ew1v1AvgWin) {
		this.ew1v1AvgWin = ew1v1AvgWin;
	}
	public Integer getEwTgRated() {
		return ewTgRated;
	}
	public void setEwTgRated(Integer ewTgRated) {
		this.ewTgRated = ewTgRated;
	}
	public Integer getEwTghighestRated() {
		return ewTghighestRated;
	}
	public void setEwTghighestRated(Integer ewTghighestRated) {
		this.ewTghighestRated = ewTghighestRated;
	}
	public Integer getEwTgStreak() {
		return ewTgStreak;
	}
	public void setEwTgStreak(Integer ewTgStreak) {
		this.ewTgStreak = ewTgStreak;
	}
	public Integer getEwTgNumWin() {
		return ewTgNumWin;
	}
	public void setEwTgNumWin(Integer ewTgNumWin) {
		this.ewTgNumWin = ewTgNumWin;
	}
	public Integer getEwTgNumLosses() {
		return ewTgNumLosses;
	}
	public void setEwTgNumLosses(Integer ewTgNumLosses) {
		this.ewTgNumLosses = ewTgNumLosses;
	}
	public Integer getEwTgAvgRated() {
		return ewTgAvgRated;
	}
	public void setEwTgAvgRated(Integer ewTgAvgRated) {
		this.ewTgAvgRated = ewTgAvgRated;
	}
	public Integer getEwTgAvgWin() {
		return ewTgAvgWin;
	}
	public void setEwTgAvgWin(Integer ewTgAvgWin) {
		this.ewTgAvgWin = ewTgAvgWin;
	}
	public Long getId() {
		return id;
	}

	public Integer getRm1v1TotalGames() {
		return rm1v1TotalGames;
	}

	public void setRm1v1TotalGames(Integer rm1v1TotalGames) {
		this.rm1v1TotalGames = rm1v1TotalGames;
	}

	public Integer getRmTgTotalGames() {
		return rmTgTotalGames;
	}

	public void setRmTgTotalGames(Integer rmTgTotalGames) {
		this.rmTgTotalGames = rmTgTotalGames;
	}

	public Integer getEw1v1TotalGames() {
		return ew1v1TotalGames;
	}

	public void setEw1v1TotalGames(Integer ew1v1TotalGames) {
		this.ew1v1TotalGames = ew1v1TotalGames;
	}

	public Integer getEwTgTotalGames() {
		return ewTgTotalGames;
	}

	public void setEwTgTotalGames(Integer ewTgTotalGames) {
		this.ewTgTotalGames = ewTgTotalGames;
	}
	
	public void updateWinRated() {
		rm1v1AvgWin = (rm1v1NumWin/rm1v1TotalGames) * 100;
		rmTgAvgRated = (rmTgNumWin/rmTgTotalGames) * 100;
		ew1v1AvgRated = (ew1v1NumWin/ew1v1TotalGames) * 100;
		ewTgAvgRated = (ewTgNumWin/ewTgTotalGames) * 100;
	}

}
