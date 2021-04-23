package com.motivastudy.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter{
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("user")
            .password(passwordEncoder().encode("password")).roles("ALUNO");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers("/")
                .permitAll()
                .anyRequest().authenticated()
            .and()
                .csrf()
                .disable();
            /*
            .antMatchers("/**")
                .hasAnyRole("ADMIN", "ALUNO")
            .anyRequest()
                .authenticated()
            .and()
                .formLogin()
                .loginProcessingUrl("/auth")
                .defaultSuccessUrl("/home")
                .permitAll()
            .and()
                .exceptionHandling()
                .accessDeniedPage("/403")
            .and()
                .logout()
                .invalidateHttpSession(true)
                .permitAll();*/

    }
}
