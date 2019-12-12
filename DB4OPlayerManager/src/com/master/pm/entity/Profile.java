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
public class Profile {

    private static final Gson GSON = new GsonBuilder().create();

    private String _id;
    private String name;

    public Profile() {
    }
    
    public Profile(String _id, String name, int dob) {
	this._id = _id;
	this.name = name;
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

    @Override
    public String toString() {
	String jsonInString = GSON.toJson(this);
	return jsonInString;
    }
    
}
