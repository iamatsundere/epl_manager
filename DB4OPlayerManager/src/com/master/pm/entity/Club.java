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
public class Club extends Profile {

    private String shortName;
    private String abbr;

    public Club() {
    }

    public Club(String shortName, String abbr) {
	this.shortName = shortName;
	this.abbr = abbr;
    }

    public Club(String shortName, String abbr, String _id, String name, int dob) {
	super(_id, name, dob);
	this.shortName = shortName;
	this.abbr = abbr;
    }

    public String getShortName() {
	return shortName;
    }

    public void setShortName(String shortName) {
	this.shortName = shortName;
    }

    public String getAbbr() {
	return abbr;
    }

    public void setAbbr(String abbr) {
	this.abbr = abbr;
    }
}
