package com.motivastudy.demo.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.motivastudy.demo.service.UsuarioDetailsServiceImpl;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter{
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
     
    public UserDetailsService usuarioDetailsService(){
        return new UsuarioDetailsServiceImpl();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(usuarioDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.cors().and()
            .csrf()
            .disable()
            .authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/cadastro").permitAll()
                .anyRequest().authenticated()
            .and()
                .formLogin()
                .successHandler(successHandler())
                .loginProcessingUrl("/dologin").permitAll()
                .failureHandler(failureHandler())
            .and() 
                .exceptionHandling()
                    .accessDeniedHandler(accessDeniedHandler())
                    .authenticationEntryPoint(authenticationEntryPoint())
            .and()
                .logout()
                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK)).permitAll()
                .invalidateHttpSession(true);

    }

    private AuthenticationSuccessHandler successHandler() {
        return new AuthenticationSuccessHandler() {
        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                Authentication authentication) throws IOException, ServletException {
                    //RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
                    //redirectStrategy.sendRedirect(request, response, "/user");
                    response.getWriter().append("Autenticado com sucesso.");
                    response.setStatus(200);
            }
        };
      }

      private AuthenticationFailureHandler failureHandler() {
        return new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
                    HttpServletResponse httpServletResponse, AuthenticationException e)
                    throws IOException, ServletException {
                Map<String,Object> respBody = new HashMap<>();
                respBody.put("mensagem","Usuário ou senha inválidos.");
                respBody.put("erro",true);
                String resp = new ObjectMapper().writeValueAsString(respBody);
                httpServletResponse.setHeader("Content-Type", "application/json;charset=utf-8");
                httpServletResponse.setContentType("application/json");
                httpServletResponse.getWriter().print(resp);
                httpServletResponse.setStatus(401);
            }
        };
    }

    private AccessDeniedHandler accessDeniedHandler() {
        return new AccessDeniedHandler() {
          @Override
          public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
            httpServletResponse.getWriter().append("Access denied");
            httpServletResponse.setStatus(403);
          }
        };
      }

      private AuthenticationEntryPoint authenticationEntryPoint() {
        return new AuthenticationEntryPoint() {
          @Override
          public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
            httpServletResponse.getWriter().append("Not authenticated");
            httpServletResponse.setStatus(401);
          }
        };
      }
      
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }

      @Bean
      CorsConfigurationSource corsConfigurationSource() 
      {
          CorsConfiguration configuration = new CorsConfiguration();
          configuration.setAllowedOrigins(Arrays.asList("*"));
          configuration.setAllowedMethods(Arrays.asList("*"));
          configuration.setAllowedHeaders(Arrays.asList("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
          "Access-Control-Request-Headers", "Allow-Origin-With-Credentials"));
          UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
          source.registerCorsConfiguration("/**", configuration);
          return source;
      }
}
