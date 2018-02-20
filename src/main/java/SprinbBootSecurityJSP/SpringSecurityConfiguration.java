package SprinbBootSecurityJSP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import SprinbBootSecurityJSP.services.MyUserDetailService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailService userDetailsService;

	@Autowired
	private AuthHandler authHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.
		csrf().disable().
		authorizeRequests()
//				.antMatchers(
//                "/assets/**",
//                "/css/**",
//                "/fonts/**",
//                "/js/**").permitAll()
		.anyRequest().authenticated().and().formLogin().loginPage("/login")
				.successHandler(authHandler).permitAll().and().logout().invalidateHttpSession(true).permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService( userDetailsService);
	}

}
