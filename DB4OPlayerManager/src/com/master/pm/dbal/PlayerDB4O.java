/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.master.pm.dbal;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.master.pm.entity.Player;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phuctt
 */
public class PlayerDB4O {

    public static final PlayerDB4O INST = new PlayerDB4O();
    private static final String DB4OFILENAME = "data/players_db";

    public void base() {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
        try {
        } finally {
            db.close();
        }
    }

    public void storePlayer(Player entry) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
        try {
            db.store(entry);
            System.out.println("Stored " + entry);
        } finally {
            db.close();
        }
    }

    public void updatePlayerById(Player entry) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
        try {
            Player player = new Player();
            player.setId(entry.getId());
            ObjectSet result = db.queryByExample(player);
            Player found = (Player) result.next();
            found.setMinutes(found.getMinutes() + entry.getMinutes());
            //update
            found.setName(entry.getName());
            found.setCountry(entry.getCountry());
            found.setClub(entry.getClub());
            found.setDob(entry.getDob());
            found.setPos(entry.getPos());
            found.setPosInfo(entry.getPosInfo());
            db.store(found);
            System.out.println(String.format("Added %d points for %s", entry.getMinutes(), entry.getGoalsScored(), found));
        } finally {
            db.close();
        }
    }

    public void deletePlayerByName(Player pilot) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
        try {
            Player player = new Player();
            player.setName(pilot.getName());
            ObjectSet result = db.queryByExample(player);
            Player found = (Player) result.next();
            db.delete(found);
        } finally {
            db.close();
        }
    }

    public void deletePlayerById(Player pilot) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
        try {
            Player player = new Player();
            player.setId(pilot.getId());
            ObjectSet result = db.queryByExample(player);
            Player found = (Player) result.next();
            db.delete(found);
        } finally {
            db.close();
        }
    }

    public List<Player> searchPlayersByQuery(Player query) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
        List<Player> listResult = new ArrayList<>();
        try {
            ObjectSet<Player> queryByExample = db.queryByExample(query);
            listResult.addAll(queryByExample);
        } finally {
            db.close();
            return listResult;
        }
    }

    public List<Player> listAllPlayers() {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
        List<Player> listResult = new ArrayList<>();
        try {
            ObjectSet<Player> queryByExample = db.query(Player.class);
            listResult.addAll(queryByExample);
        } finally {
            db.close();
            return listResult;
        }
    }
}
