package com.application.library.security;


import com.application.library.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@EnableJpaRepositories (basePackageClasses = UserRepository.class)
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private OwnUserDetailsService ownUserDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(ownUserDetailsService)
                .passwordEncoder(getPasswordEncoder());
    }






    @Override

    protected void configure(HttpSecurity http) throws Exception {

       http.addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class);

       http

               .authorizeRequests().antMatchers("/valid").permitAll()
               .antMatchers("/")

              .permitAll()

               .anyRequest()

    .fullyAuthenticated()

              .and()

              .httpBasic()

              .and().csrf().disable();

    }



    private PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {

                Boolean isGood;
                if(charSequence.equals(s))
                {
                    isGood=true;
                }
                else {
                    isGood=false;
                }

                return isGood;
            }
        };
    }

}
