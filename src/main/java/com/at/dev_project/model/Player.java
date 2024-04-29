/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.dev_project.model;

/**
 *
 * @author dell
 */
public class Player {
    
    String name;
    String age;
    String nationnality;
    double height;
    double weight;
    String position_name;    
    String carrier_start_date;

    public Player(String name, String age, String nationnality, double height, double weight, String position_name, String carrier_start_date) {
        this.name = name;
        this.age = age;
        this.nationnality = nationnality;
        this.height = height;
        this.weight = weight;
        this.position_name = position_name;
        this.carrier_start_date = carrier_start_date;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getNationnality() {
        return nationnality;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getPosition_name() {
        return position_name;
    }

    public String getCarrier_start_date() {
        return carrier_start_date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setNationnality(String nationnality) {
        this.nationnality = nationnality;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public void setCarrier_start_date(String carrier_start_date) {
        this.carrier_start_date = carrier_start_date;
    }

    
    
}
