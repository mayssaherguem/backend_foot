/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.dev_project.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

/**
 *
 * @author dell
 */

@Service
public class PlayersService {
    
    
    @Autowired
    @Qualifier("jdbcTemplate_players")
    private JdbcTemplate jdbcTemplate;
 
    public PlayersService() {}
    
    public List getList_players()
    {
        List list = new ArrayList();
        String sql = "SELECT * FROM players ";
        SqlRowSet raws_values = jdbcTemplate.queryForRowSet(sql);
        while(raws_values.next()){
            HashMap hm = new HashMap();             
            hm.put("id", raws_values.getInt("id")); 
            hm.put("name", raws_values.getString("name"));
            hm.put("age", raws_values.getString("age"));
            hm.put("nationality", raws_values.getString("nationality"));
            hm.put("number", raws_values.getDouble("number"));
            hm.put("height", raws_values.getDouble("height"));
            hm.put("weight", raws_values.getDouble("weight"));
            hm.put("position_name", raws_values.getString("position_name"));
            hm.put("carrier_start_date", raws_values.getString("carrier_start_date"));
            
            
            
            list.add(hm);
        }
        return list;
    }
    
    
    public boolean insertReq( JSONObject json )
    {
        String req="INSERT INTO public.players( " +
        "id, " +
        "name, " +
        "age, " +
        "nationality, " +
        "number, " +
        "height, " +
        "weight, " +
        "position_name, " +
        "carrier_start_date " +
        
        ") " +
        " VALUES " +
        "( (SELECT COALESCE(MAX(id), 0) + 1 from players), " +
        "  '"+json.get("name")+"', " +
        "  '"+json.get("age")+"', " +
        "  '"+json.get("nationality")+"', " +
         "  '"+json.get("number")+"', " +
        "  '"+json.get("height")+"', " +
        "  '"+json.get("weight")+"', " +
        "  '"+json.get("position_name")+"', " +
        "  '"+json.get("carrier_start_date")+"' " +
        ");";
        
        System.out.println(req);
        jdbcTemplate.execute(req);
        
        return true;
    }
    
    public String editReq(int id, String name, String age, String nationality, double number, double height, double weight, String position_name, String carrier_start_date)
    {
        String req = "UPDATE players SET name=?, age=?, nationality=?, number=?, height=?, weight=?, position_name=?, carrier_start_date=? where  id = '"+id+"'"; 
        jdbcTemplate.update(req, name, age, nationality, number, height, weight, position_name, carrier_start_date);
        
        return req;
    }
    
    public String deleteReq( int id )
    {
        String req= "DELETE FROM public.players where id = '"+id+"'" ;
        jdbcTemplate.execute(req);
        
        return req;
    }
    
}
