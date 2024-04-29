package com.at.dev_project.configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DatasourceBean 
{
    @Autowired
    private Environment env;
       
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
   
   
    @Bean
    public DataSource players(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty( "foot.datasource.url" ));
        dataSource.setDriverClassName(env.getProperty( "foot.datasource.driver" ));
        dataSource.setUsername(env.getProperty( "foot.datasource.username" ));
        dataSource.setPassword(env.getProperty( "foot.datasource.password" ));
        return dataSource;
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate_players( @Qualifier("players") DataSource dataSource )
    {
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        return jt;
    }
    

    
    
    
}
