/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.dev_project.controllers;

import com.at.dev_project.services.PlayersService;
import java.util.HashMap;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dell
 */

@RestController
public class PlayersControllers {
    
    @Autowired
    private PlayersService ps;
    
    @CrossOrigin()
    @PostMapping("/getList_players")
    public HashMap getList_players()
    {
        HashMap hm_ = new HashMap(); 
        hm_.put( "data", ps.getList_players() );
        return hm_;
    }
    
    
    @CrossOrigin()
    @PostMapping("/add_players")
    public boolean add_players(String name, String age, String nationality, double number, double height, double weight, String position_name, String carrier_start_date) 
    {
        JSONObject json = new JSONObject();
        json.put("name", name) ; 
        json.put("age", age );            
        json.put("nationality", nationality );          
        json.put("number", number);
        json.put("height", height );      
        json.put("weight", weight );      
        json.put("position_name", position_name );      
        json.put("carrier_start_date", carrier_start_date );      
        
        //json.put("status", status );           
        boolean b = ps.insertReq(json);
        return b;
    }
    
    @CrossOrigin()
    @PostMapping("/editPlayer")
    public String editPlayer(int id, String name, String age, String nationality, double number, double height, double weight, String position_name, String carrier_start_date)
    {
        String s = ps.editReq(id, name, age, nationality, number, height, weight, position_name, carrier_start_date);
        return s;
    }
    
    @CrossOrigin()
    @PostMapping("/deletePlayer")
    public String addDestinataire(int id)
    {
        String s = ps.deleteReq(id);
        return s;
    }
    
}
