/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.master.pm.dbal;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.master.pm.entity.Club;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phuctt
 */
public class ClubDB4O {

    public static final ClubDB4O INST = new ClubDB4O();
    private static final String DB4OFILENAME = "data/clubs_db";

    public void base() {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
        try {
        } finally {
            db.close();
        }
    }

    public void storeClub(Club entry) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
        try {
            db.store(entry);
            System.out.println("Stored " + entry);
        } finally {
            db.close();
        }
    }

    public void deleteClubByName(Club pilot) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
        try {
            Club player = new Club();
            player.setName(pilot.getName());
            ObjectSet result = db.queryByExample(player);
            Club found = (Club) result.next();
            db.delete(found);
        } finally {
            db.close();
        }
    }

    public void deleteClubById(Club pilot) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
        try {
            Club player = new Club();
            player.setId(pilot.getId());
            ObjectSet result = db.queryByExample(player);
            Club found = (Club) result.next();
            db.delete(found);
        } finally {
            db.close();
        }
    }

    public List<Club> searchClubsByQuery(Club query) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
        List<Club> listResult = new ArrayList<>();
        try {
            ObjectSet<Club> queryByExample = db.queryByExample(query);
            listResult.addAll(queryByExample);
        } finally {
            db.close();
            return listResult;
        }
    }

    public List<Club> listAllClubs() {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
        List<Club> listResult = new ArrayList<>();
        try {
            ObjectSet<Club> queryByExample = db.query(Club.class);
            listResult.addAll(queryByExample);
        } finally {
            db.close();
            return listResult;
        }
    }
}
