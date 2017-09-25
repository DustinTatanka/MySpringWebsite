package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .regexMatchers("/admin\\?user=.*\\Z").hasRole("ADMIN")
                .regexMatchers("/admin/\\?user=.*\\Z").hasRole("ADMIN")
                .regexMatchers("/admin/.*\\Z").hasRole("ADMIN")
        .and()
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/admin.html",true)
                .failureUrl("/loginerror");
    }

    @Autowired
    public void configureGloba(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("*******").roles("ADMIN");
    }

}
