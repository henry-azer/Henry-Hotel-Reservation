package henry.hotel.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import henry.hotel.services.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// field injection for user service
	@Autowired
	private UserService userService;

	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.authorizeRequests()
		.antMatchers("/login-form-page").permitAll()
		.antMatchers("/", "/new-reservation", "/your-reservations").hasAnyRole("EMPLOYEE")
		.and()
		.formLogin()
			.loginPage("/login-form-page")
			.loginProcessingUrl("/process-login")
			.successHandler(customAuthenticationSuccessHandler)
			.permitAll()
		.and()
		.logout()
			.logoutUrl("/login-form-page")
			.permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/403");
	}

	// beans
	
	// bcrypt bean definition
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// authenticationProvider bean definition
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService); 
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
}
