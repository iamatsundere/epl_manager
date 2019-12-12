/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.master.pm.entity;


/**
 *
 * @author phuctt
 */
public class Player extends Footballer {

    private String pos;
    private String posInfo;
    private int shirtNum;
    private int yellowCards;
    private int redCards;
    private int minutes;
    private int goalsScored;
    private int assists;
    private int ownGoals;
    private int penaltiesMissed;
    private int saves;
    private int cleanSheets;
    private int goalsConceded;
    private int penaltiesSaved;

    public Player() {
    }

    public Player(String pos, String posInfo, int shirtNum, int yellowCards, int redCards, int minutes, int goalsScored, int assists, int ownGoals, int penaltiesMissed, int saves, int cleanSheets, int goalsConceded, int penaltiesSaved) {
	this.pos = pos;
	this.posInfo = posInfo;
	this.shirtNum = shirtNum;
	this.yellowCards = yellowCards;
	this.redCards = redCards;
	this.minutes = minutes;
	this.goalsScored = goalsScored;
	this.assists = assists;
	this.ownGoals = ownGoals;
	this.penaltiesMissed = penaltiesMissed;
	this.saves = saves;
	this.cleanSheets = cleanSheets;
	this.goalsConceded = goalsConceded;
	this.penaltiesSaved = penaltiesSaved;
    }

    public Player(String pos, String posInfo, int shirtNum, int yellowCards, int redCards, int minutes, int goalsScored, int assists, int ownGoals, int penaltiesMissed, int saves, int cleanSheets, int goalsConceded, int penaltiesSaved, String _id, String name, String firstName, String lastName, String club, String clubAbbr, int dob, String country, String countryCode) {
	super(firstName, lastName, club, clubAbbr, dob, country, countryCode);
	this.pos = pos;
	this.posInfo = posInfo;
	this.shirtNum = shirtNum;
	this.yellowCards = yellowCards;
	this.redCards = redCards;
	this.minutes = minutes;
	this.goalsScored = goalsScored;
	this.assists = assists;
	this.ownGoals = ownGoals;
	this.penaltiesMissed = penaltiesMissed;
	this.saves = saves;
	this.cleanSheets = cleanSheets;
	this.goalsConceded = goalsConceded;
	this.penaltiesSaved = penaltiesSaved;
    }

    public String getPos() {
	return pos;
    }

    public void setPos(String pos) {
	this.pos = pos;
    }

    public String getPosInfo() {
	return posInfo;
    }

    public void setPosInfo(String posInfo) {
	this.posInfo = posInfo;
    }

    public int getYellowCards() {
	return yellowCards;
    }

    public void setYellowCards(int yellowCards) {
	this.yellowCards = yellowCards;
    }

    public int getRedCards() {
	return redCards;
    }

    public void setRedCards(int redCards) {
	this.redCards = redCards;
    }

    public int getMinutes() {
	return minutes;
    }

    public void setMinutes(int minutes) {
	this.minutes = minutes;
    }

    public int getGoalsScored() {
	return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
	this.goalsScored = goalsScored;
    }

    public int getAssists() {
	return assists;
    }

    public void setAssists(int assists) {
	this.assists = assists;
    }

    public int getOwnGoals() {
	return ownGoals;
    }

    public void setOwnGoals(int ownGoals) {
	this.ownGoals = ownGoals;
    }

    public int getPenaltiesMissed() {
	return penaltiesMissed;
    }

    public void setPenaltiesMissed(int penaltiesMissed) {
	this.penaltiesMissed = penaltiesMissed;
    }

    public int getSaves() {
	return saves;
    }

    public void setSaves(int saves) {
	this.saves = saves;
    }

    public int getCleanSheets() {
	return cleanSheets;
    }

    public void setCleanSheets(int cleanSheets) {
	this.cleanSheets = cleanSheets;
    }

    public int getGoalsConceded() {
	return goalsConceded;
    }

    public void setGoalsConceded(int goalsConceded) {
	this.goalsConceded = goalsConceded;
    }

    public int getPenaltiesSaved() {
	return penaltiesSaved;
    }

    public void setPenaltiesSaved(int penaltiesSaved) {
	this.penaltiesSaved = penaltiesSaved;
    }

    public int getShirtNum() {
	return shirtNum;
    }

    public void setShirtNum(int shirtNum) {
	this.shirtNum = shirtNum;
    }
}
