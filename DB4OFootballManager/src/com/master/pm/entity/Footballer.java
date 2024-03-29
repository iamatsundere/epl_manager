/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.master.pm.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author phuctt
 */
public class Footballer extends Profile {

    private static final Gson GSON = new GsonBuilder().create();

    private String firstName;
    private String lastName;
    private String club;
    private long dob;
    private String country;

    public Footballer() {
    }

    public Footballer(String firstName, String lastName, String club, String clubAbbr, int dob, String country, String countryCode) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.club = club;
	this.dob = dob;
	this.country = country;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getClub() {
	return club;
    }

    public void setClub(String club) {
	this.club = club;
    }

    public long getDob() {
	return dob;
    }

    public void setDob(long dob) {
	this.dob = dob;
    }

    public String getCountry() {
	return country;
    }

    public void setCountry(String country) {
	this.country = country;
    }

    @Override
    public String toString() {
	String jsonInString = GSON.toJson(this);
	return jsonInString;
    }

}
