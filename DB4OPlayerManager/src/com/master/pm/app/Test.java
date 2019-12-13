/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.master.pm.app;

import com.master.pm.dbal.PlayerDB4O;
import com.master.pm.entity.Player;
import java.util.List;

/**
 *
 * @author phuctt
 */
public class Test {

    public static void main(String[] args) {
	List<Player> listAllPlayers = PlayerDB4O.INST.searchPlayersByAdvancedQuery("Da", "", "", -1, -1);
//	List<Player> listAllPlayers = ada.listAllPlayers();
	System.out.println(listAllPlayers);
    }
}
