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

    private String _id;
    private String name;
    private String firstName;
    private String lastName;
    private String club;
    private int dob;
    private String country;

    public Footballer() {
    }

    public Footballer(String _id, String name, String firstName, String lastName, String club, String clubAbbr, int dob, String country, String countryCode) {
	this._id = _id;
	this.name = name;
	this.firstName = firstName;
	this.lastName = lastName;
	this.club = club;
	this.dob = dob;
	this.country = country;
    }

    public String getId() {
	return _id;
    }

    public void setId(String _id) {
	this._id = _id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
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

    public int getDob() {
	return dob;
    }

    public void setDob(int dob) {
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
