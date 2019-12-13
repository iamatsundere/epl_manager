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
public class Manager extends Footballer {

    private boolean active;

    public Manager() {
    }

    public Manager(boolean active) {
	this.active = active;
    }

    public Manager(boolean active, String _id, String name, String firstName, String lastName, String club, String clubAbbr, int dob, String country, String countryCode) {
	super(firstName, lastName, club, clubAbbr, dob, country, countryCode);
	this.active = active;
    }

    public boolean isActive() {
	return active;
    }

    public void setActive(boolean active) {
	this.active = active;
    }
}
