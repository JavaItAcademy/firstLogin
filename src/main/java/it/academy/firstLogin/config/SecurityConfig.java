package it.academy.firstLogin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password(passwordEncoder().encode("12345")).roles("USER")
//                .and().withUser("admin").password(passwordEncoder().encode("12345")).roles("ADMIN");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .httpBasic().and().authorizeRequests()
//                .antMatchers("/api/items", "/api/items/").hasRole("USER")
//                .antMatchers("/api/addItem/", "api/addItem", "/**", "api/**").hasRole("ADMIN")
//                .anyRequest().authenticated();
//    }
//
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("12345")).roles("USER").and()
                .withUser("admin").password(passwordEncoder().encode("12345")).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers("/api/items", "/api/items/").hasRole("USER")
                .antMatchers("/api/**").hasRole("ADMIN")
                .anyRequest().authenticated();
    }
}
