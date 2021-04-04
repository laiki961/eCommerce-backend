package com.ventail.ecommerce.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.ventail.ecommerce.FirebaseSecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

@Configuration
@EnableWebSecurity //communicate with spring root to activate
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private FirebaseSecurityFilter firebaseSecurityFilter;

    @PostConstruct
    public void initFirebase() throws IOException {
        // load firebase_config.jason form ClassPathResource
        InputStream serviceAccount = new ClassPathResource("firebase_config.json").getInputStream();

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        // load to firebase
        FirebaseApp.initializeApp(options);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //builder pattern <- search
        http
                .cors()
                .and()
                .httpBasic().disable() //turn off http basic login
                .authorizeRequests()
                    .antMatchers("/public/**").permitAll()
                    .anyRequest().authenticated() //**any requests that comes in are needed to be authenticated
                .and()
                .addFilterBefore(firebaseSecurityFilter, UsernamePasswordAuthenticationFilter.class) //every request are needed to calling this filter
                .csrf().disable();
    }
}

