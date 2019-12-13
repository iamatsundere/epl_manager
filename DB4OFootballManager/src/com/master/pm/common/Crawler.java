/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.master.pm.common;

import com.master.pm.dbal.ClubDB4O;
import com.master.pm.dbal.ManagerDB4O;
import com.master.pm.dbal.PlayerDB4O;
import com.master.pm.entity.Club;
import com.master.pm.entity.Manager;
import com.master.pm.entity.Player;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author phuctt
 */
public class Crawler {

    public void crawlPlayer() {
	try {
	    String json = Utils.Instance.readAllBytesJava("resources/players.json");

	    JSONParser parser = new JSONParser();
	    JSONArray jsonArr = (JSONArray) parser.parse(json);
	    Player entry;
	    int count = 0;

	    for (int i = 0; i < jsonArr.size(); i++) {

		JSONObject jsonPlayersPage = (JSONObject) jsonArr.get(i);
		JSONArray jsonPlayers = (JSONArray) jsonPlayersPage.get("content");

		for (int j = 0; j < jsonPlayers.size(); j++) {
		    count++;

		    JSONObject player = (JSONObject) jsonPlayers.get(j);
		    entry = new Player();
		    entry.setAssists(0);
		    entry.setCleanSheets(0);

		    try {

			if (player.containsKey("currentTeam")) {
			    JSONObject currentTeam = (JSONObject) player.get("currentTeam");
			    JSONObject altIds = (JSONObject) currentTeam.get("altIds");
			    entry.setClub(altIds.get("opta").toString());
			}

			JSONObject nationalTeam = (JSONObject) player.get("nationalTeam");
			entry.setCountry(nationalTeam.containsKey("country") ? nationalTeam.get("country").toString() : "");

			try {
			    JSONObject date = (JSONObject) ((JSONObject) player.get("birth")).get("date");
			    String dob = date.get("millis").toString();
//			    System.out.println(dob + "_" + new BigDecimal(dob).longValue());
			    entry.setDob((new BigDecimal(dob).longValue()) / 1000);
			} catch (Exception ex) {
			    entry.setDob(0);
			}

			JSONObject name = (JSONObject) player.get("name");
			entry.setFirstName(name.get("first").toString());
			entry.setLastName(name.get("last").toString());
			entry.setName(name.get("display").toString());

			JSONObject altIds = (JSONObject) player.get("altIds");
			entry.setId(altIds.get("opta").toString());

			JSONObject info = (JSONObject) player.get("info");
			entry.setPos(info.get("position").toString());
			entry.setPosInfo(info.get("positionInfo").toString());
			try {
			    entry.setShirtNum(new BigDecimal(info.get("shirtNum").toString()).intValue());
			} catch (Exception ex) {
			    entry.setShirtNum(0);
			}

			entry.setGoalsConceded(0);
			entry.setGoalsScored(0);
			entry.setMinutes(0);
			entry.setOwnGoals(0);
			entry.setPenaltiesMissed(0);
			entry.setPenaltiesSaved(0);
			entry.setRedCards(0);
			entry.setSaves(0);
			entry.setYellowCards(0);

//			System.out.println(entry);
			PlayerDB4O.INST.storePlayer(entry);
		    } catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(player);
		    }
		}
	    }
	    System.out.println(count);
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }

    public void crawlClub() {
	try {
	    String json = Utils.Instance.readAllBytesJava("resources/players.json");

	    JSONParser parser = new JSONParser();
	    JSONArray jsonArr = (JSONArray) parser.parse(json);
	    Map<String, Club> mapClubs = new HashMap<>();
	    Club entry;
	    int count = 0;

	    for (int i = 0; i < jsonArr.size(); i++) {
		JSONObject jsonPlayersPage = (JSONObject) jsonArr.get(i);
		JSONArray jsonPlayers = (JSONArray) jsonPlayersPage.get("content");
		for (int j = 0; j < jsonPlayers.size(); j++) {
		    count++;
		    JSONObject player = (JSONObject) jsonPlayers.get(j);
		    entry = new Club();
		    try {
			if (player.containsKey("currentTeam")) {
			    JSONObject currentTeam = (JSONObject) player.get("currentTeam");
			    JSONObject altIds = (JSONObject) currentTeam.get("altIds");
			    entry.setId(altIds.get("opta").toString());
			    entry.setName(currentTeam.get("name").toString());
			    entry.setShortName(currentTeam.get("shortName").toString());

			    JSONObject club = (JSONObject) currentTeam.get("club");
			    entry.setAbbr(club.get("abbr").toString());

			    mapClubs.put(entry.getId(), entry);
			}
		    } catch (Exception ex) {
			ex.printStackTrace();
		    }
		}
	    }
	    for (Map.Entry<String, Club> entryMap : mapClubs.entrySet()) {
		System.out.println(entryMap.getValue());
		ClubDB4O.INST.storeClub(entryMap.getValue());
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }

    public void crawlManager() {
	try {
	    String jsonString = Utils.Instance.readAllBytesJava("resources/managers.json");

	    JSONParser parser = new JSONParser();
	    JSONObject json = (JSONObject) parser.parse(jsonString);
	    JSONArray jsonArr = (JSONArray) json.get("content");
	    Manager entry;
	    int count = 0;

	    for (int j = 0; j < jsonArr.size(); j++) {
		count++;
		JSONObject manager = (JSONObject) jsonArr.get(j);
		entry = new Manager();
		try {
		    JSONObject altIds = (JSONObject) manager.get("altIds");
		    entry.setId(altIds.get("opta").toString());

		    entry.setActive((boolean) manager.get("active"));
		    if (manager.containsKey("currentTeam")) {
			JSONObject currentTeam = (JSONObject) manager.get("currentTeam");
			JSONObject altIdsClub = (JSONObject) currentTeam.get("altIds");
			entry.setClub(altIdsClub.get("opta").toString());
		    }

		    JSONObject birth = (JSONObject) manager.get("birth");
		    try {
			JSONObject date = (JSONObject) birth.get("date");
			String dob = date.get("millis").toString();
			entry.setDob(new BigDecimal(dob).intValue());
		    } catch (Exception ex) {
			entry.setDob(0);
		    }

		    JSONObject name = (JSONObject) manager.get("name");
		    entry.setFirstName(name.get("first").toString());
		    entry.setLastName(name.get("last").toString());
		    entry.setName(name.get("display").toString());

		    JSONObject country = (JSONObject) birth.get("country");
		    entry.setCountry(country.containsKey("country") ? country.get("country").toString() : "");
		} catch (Exception ex) {
		    ex.printStackTrace();
		    System.out.println(manager);
		}

		System.out.println(manager);
		ManagerDB4O.INST.storeManager(entry);
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }

    public static void main(String[] args) {
	Crawler c = new Crawler();
//	c.crawlPlayer();
//	c.crawlClub();
	c.crawlManager();
	System.exit(0);
    }
}
