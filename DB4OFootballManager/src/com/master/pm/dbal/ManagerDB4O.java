/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.master.pm.dbal;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.master.pm.entity.Manager;
import com.master.pm.entity.Manager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phuctt
 */
public class ManagerDB4O {

    public static final ManagerDB4O INST = new ManagerDB4O();
    private static final String DB4OFILENAME = "data/managers_db";
    private static final ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);

    public void base() {
	//ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
	try {
	} finally {
	    //db.close();
	}
    }

    public void storeManager(Manager entry) {
	//ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
	try {
	    db.store(entry);
	    System.out.println("Stored " + entry);
	} finally {
	    //db.close();
	}
    }
    
    public void updateManagerById(Manager entry) {
	try {
	    Manager player = new Manager();
	    player.setId(entry.getId());
	    ObjectSet result = db.queryByExample(player);
	    Manager found = (Manager) result.next();
	    //update
	    found.setActive(entry.isActive());
	    found.setCountry(entry.getCountry());
	    found.setClub(entry.getClub());
	    found.setName(entry.getName());
	    found.setFirstName(entry.getFirstName());
	    found.setLastName(entry.getLastName());
	    found.setDob(entry.getDob());
	    db.store(found);
	} finally {
	    ////db.close();
	}
    }

    public void deleteManagerByName(Manager pilot) {
	try {
	    Manager player = new Manager();
	    player.setName(pilot.getName());
	    ObjectSet result = db.queryByExample(player);
	    Manager found = (Manager) result.next();
	    db.delete(found);
	} finally {
	}
    }

    public void deleteManagerById(Manager pilot) {
	//ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
	try {
	    Manager player = new Manager();
	    player.setId(pilot.getId());
	    ObjectSet result = db.queryByExample(player);
	    Manager found = (Manager) result.next();
	    db.delete(found);
	} finally {
	    //db.close();
	}
    }

    public List<Manager> searchManagersByQuery(Manager query) {
	//ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
	List<Manager> listResult = new ArrayList<>();
	try {
	    ObjectSet<Manager> queryByExample = db.queryByExample(query);
	    listResult.addAll(queryByExample);
	    return listResult;
	} finally {
	    //db.close();
	}
    }

    public List<Manager> listAllManagers() {
	//ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
	List<Manager> listResult = new ArrayList<>();
	try {
	    ObjectSet<Manager> queryByExample = db.query(Manager.class);
	    listResult.addAll(queryByExample);
	    return listResult;
	} finally {
	    //db.close();
	}
    }
}
