/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.master.pm.common;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author phuctt
 */
public class Utils {

    public static final Utils Instance = new Utils();

    public String readAllBytesJava(String filePath) {
	String content = "";
	try {
	    content = new String(Files.readAllBytes(Paths.get(filePath)));
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return content;
    }
}
