package com.lehoangglam.workscout.config;

import com.lehoangglam.workscout.services.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserService customUserService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("A")
                .password(passwordEncoder().encode("123")).authorities("admin");

        auth.userDetailsService(customUserService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin().loginPage("/login")
//                .usernameParameter("username")
//                .passwordParameter("password");
//
//        http.formLogin().defaultSuccessUrl("/").failureUrl("/login?error");
//        http.formLogin().successHandler(loginHandler);
//
//        http.authorizeRequests().antMatchers("/").permitAll()
//                .antMatchers("/admin/**").hasRole("ADMIN");
//
//        http.csrf().disable();
        http.authorizeRequests().anyRequest().authenticated();
        http.formLogin();
        http.httpBasic();

    }
}
