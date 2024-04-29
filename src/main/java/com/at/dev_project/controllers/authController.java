/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.dev_project.controllers;

import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class authController {
   @Autowired
    @Qualifier("jdbcTemplate_players")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ApplicationContext applicationContext;
    
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public authController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    
    @CrossOrigin()
    @PostMapping("/Authentification")
    
    public JSONObject Authentification(String login, String password)
    {
        JSONObject json = new JSONObject();
        String errorStatus = "";
        
            JSONObject json1 = new JSONObject();
            errorStatus = "conn ";
            //password=StringEncrypter.encrypt(password);
            String pass=passwordEncoder.encode(password);
            String req = "select * from users where (login='"+login+"' AND pwd='"+pass+"') or (login='"+login+"')";
            errorStatus = "query  ";
            SqlRowSet res  = jdbcTemplate.queryForRowSet(req);
            //System.out.println(req);
            ArrayList<String> login_ = new ArrayList<String>();
            ArrayList<String> pass_ = new ArrayList<String>();
            ArrayList<String> niveau = new ArrayList<String>();
            

            if (!res.next())
            {
                json.put("msg", "notok");
                //System.out.println("no data");
            }
            //while(res.next())
            else if(res.getString("login").equals(login) && !res.getString("pwd").equals(password))
            {
                json.put("login", res.getString("login"));
                json.put("msg", "pass incorrect");
            }
            else if(res.getString("login").equals(login) && res.getString("pwd").equals(password) )
            {
                //System.out.println("else");

                json.put("id", res.getString("id") );
                json.put("name", res.getString("name"));
                json.put("login", res.getString("login"));
                json.put("password", res.getString("pwd"));
                json.put("level", res.getString("level"));
                json.put("token", "ok");
                json.put("email", res.getString("email"));

                json.put("msg", "ok");

            }
        
        return json;
        
    } 
}
