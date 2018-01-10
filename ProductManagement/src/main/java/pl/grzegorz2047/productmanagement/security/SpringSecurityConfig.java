package pl.grzegorz2047.productmanagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationEntryPoint authEntryPoint;

    @Autowired
    private CustomAuthenticationProvider authProvider;


    //https://medium.com/@gustavo.ponce.ch/spring-boot-spring-mvc-spring-security-mysql-a5d8545d837d
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/users/all").hasAuthority("ADMIN_USERS_READ")
                .antMatchers("/opinions/all").authenticated()
                .antMatchers("/products/all").authenticated()
                .antMatchers("/users/add").permitAll()
                .antMatchers("/opinions/add").permitAll()
                .antMatchers("/products/add").permitAll()
                .and().httpBasic();
        //.authenticationEntryPoint(authEntryPoint);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {//hardcored authorization credentials
        auth.authenticationProvider(authProvider);
//        auth.inMemoryAuthentication().withUser("admin").password("admin1").roles("ADMIN");//Pobierac z bazy danych zamiast z kodu :D
    }

}
