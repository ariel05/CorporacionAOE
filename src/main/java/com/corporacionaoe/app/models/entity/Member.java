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
	private Integer rm1v1Rated;
	private Integer rm1v1highestRated;
	private Integer rm1v1Streak;
	private Integer rm1v1NumWin;
	private Integer rm1v1NumLosses;
	private Integer rm1v1MaxRated;
	private Integer rm1v1AvgRated;
	private Integer rm1v1AvgWin;
	//RM 1v1
	private Integer rmTgRated;
	private Integer rmTghighestRated;
	private Integer rmTgStreak;
	private Integer rmTgNumWin;
	private Integer rmTgNumLosses;
	private Integer rmTgMaxRated;
	private Integer rmTgAvgRated;
	private Integer rmTgAvgWin;
	//RM 1v1
	private Integer ew1v1Rated;
	private Integer ew1v1highestRated;
	private Integer ew1v1Streak;
	private Integer ew1v1NumWin;
	private Integer ew1v1NumLosses;
	private Integer ew1v1MaxRated;
	private Integer ew1v1AvgRated;
	private Integer ew1v1AvgWin;
	//RM 1v1
	private Integer ewTgRated;
	private Integer ewTghighestRated;
	private Integer ewTgStreak;
	private Integer ewTgNumWin;
	private Integer ewTgNumLosses;
	private Integer ewTgMaxRated;
	private Integer ewTgAvgRated;
	private Integer ewTgAvgWin;
	
	public Member() {}
	
	public Member(Integer profileId, Integer steamId, String name, CountryEnum country, Integer rm1v1Rated,
			Integer rm1v1highestRated, Integer rm1v1Streak, Integer rm1v1NumWin, Integer rm1v1NumLosses,
			Integer rm1v1MaxRated, Integer rm1v1AvgRated, Integer rm1v1AvgWin, Integer rmTgRated,
			Integer rmTghighestRated, Integer rmTgStreak, Integer rmTgNumWin, Integer rmTgNumLosses,
			Integer rmTgMaxRated, Integer rmTgAvgRated, Integer rmTgAvgWin, Integer ew1v1Rated,
			Integer ew1v1highestRated, Integer ew1v1Streak, Integer ew1v1NumWin, Integer ew1v1NumLosses,
			Integer ew1v1MaxRated, Integer ew1v1AvgRated, Integer ew1v1AvgWin, Integer ewTgRated,
			Integer ewTghighestRated, Integer ewTgStreak, Integer ewTgNumWin, Integer ewTgNumLosses,
			Integer ewTgMaxRated, Integer ewTgAvgRated, Integer ewTgAvgWin) {
		this.profileId = profileId;
		this.steamId = steamId;
		this.name = name;
		this.country = country;
		this.rm1v1Rated = rm1v1Rated;
		this.rm1v1highestRated = rm1v1highestRated;
		this.rm1v1Streak = rm1v1Streak;
		this.rm1v1NumWin = rm1v1NumWin;
		this.rm1v1NumLosses = rm1v1NumLosses;
		this.rm1v1MaxRated = rm1v1MaxRated;
		this.rm1v1AvgRated = rm1v1AvgRated;
		this.rm1v1AvgWin = rm1v1AvgWin;
		this.rmTgRated = rmTgRated;
		this.rmTghighestRated = rmTghighestRated;
		this.rmTgStreak = rmTgStreak;
		this.rmTgNumWin = rmTgNumWin;
		this.rmTgNumLosses = rmTgNumLosses;
		this.rmTgMaxRated = rmTgMaxRated;
		this.rmTgAvgRated = rmTgAvgRated;
		this.rmTgAvgWin = rmTgAvgWin;
		this.ew1v1Rated = ew1v1Rated;
		this.ew1v1highestRated = ew1v1highestRated;
		this.ew1v1Streak = ew1v1Streak;
		this.ew1v1NumWin = ew1v1NumWin;
		this.ew1v1NumLosses = ew1v1NumLosses;
		this.ew1v1MaxRated = ew1v1MaxRated;
		this.ew1v1AvgRated = ew1v1AvgRated;
		this.ew1v1AvgWin = ew1v1AvgWin;
		this.ewTgRated = ewTgRated;
		this.ewTghighestRated = ewTghighestRated;
		this.ewTgStreak = ewTgStreak;
		this.ewTgNumWin = ewTgNumWin;
		this.ewTgNumLosses = ewTgNumLosses;
		this.ewTgMaxRated = ewTgMaxRated;
		this.ewTgAvgRated = ewTgAvgRated;
		this.ewTgAvgWin = ewTgAvgWin;
	}
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
	public Integer getRm1v1MaxRated() {
		return rm1v1MaxRated;
	}
	public void setRm1v1MaxRated(Integer rm1v1MaxRated) {
		this.rm1v1MaxRated = rm1v1MaxRated;
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
	public Integer getRmTgMaxRated() {
		return rmTgMaxRated;
	}
	public void setRmTgMaxRated(Integer rmTgMaxRated) {
		this.rmTgMaxRated = rmTgMaxRated;
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
	public Integer getEw1v1MaxRated() {
		return ew1v1MaxRated;
	}
	public void setEw1v1MaxRated(Integer ew1v1MaxRated) {
		this.ew1v1MaxRated = ew1v1MaxRated;
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
	public Integer getEwTgMaxRated() {
		return ewTgMaxRated;
	}
	public void setEwTgMaxRated(Integer ewTgMaxRated) {
		this.ewTgMaxRated = ewTgMaxRated;
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
	

}
