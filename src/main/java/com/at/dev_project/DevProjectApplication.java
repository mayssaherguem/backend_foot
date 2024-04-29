package com.at.dev_project;

import java.sql.SQLException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DevProjectApplication implements CommandLineRunner {

    
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = SpringApplication.run(DevProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //kd.getList_global("Moov2g",new String[]{"cdr","cssr"}, "day", "20221116", "10:00");

    }
    
   

}
