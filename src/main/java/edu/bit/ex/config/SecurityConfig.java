package edu.bit.ex.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import edu.bit.ex.encoder.PWEncoder;
import edu.bit.ex.service.SecurityService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private SecurityService service;
	
	@Bean
	public DaoAuthenticationProvider auth(SecurityService securityService) {
		
	// AuthenticationProvider 가 UserDeatils 에게 유저로 부터 받은 아이디 값을 넘겨 줘야함
	//DaoAuthenticationProvider는 Userdetails를 구현한 클래스를 setUserDetailsService() 파라미터 값으로 받고 내부적으로 loadUserByUsername 메소드를 처리
		
		 DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		 authenticationProvider.setUserDetailsService(securityService);
		 // 비밀번호는 암호화 처리 안했는데 어떻게 구현하지? 
		return authenticationProvider;
	
	}

	@Override
	public void configure(WebSecurity web) {
		//이미지,자바스크립트,css 디렉토리 보안 설정 
		
		web.ignoring().antMatchers("/static/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//HTTP 관련 보안 설정 **가장 중요   
		
		http
			.authorizeRequests().antMatchers("/", "/login").permitAll()
				.antMatchers("/login", "/user").access("hasRole('ROLE_USER')")
				.antMatchers("/login", "/admin").access("hasRole('ROLE_ADMIN')")
				.anyRequest().authenticated()
			.and()
				.formLogin().loginPage("/login").defaultSuccessUrl("/accessDenied", true)
			.and()
				.logout().logoutSuccessUrl("/logout").invalidateHttpSession(true) //session날리기
			.and()
				.csrf().ignoringAntMatchers("/login");
				
	}
	
	@Bean // 비밀번호 암호화
	public PasswordEncoder passwordEncoder() {
		return new PWEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.userDetailsService(service).passwordEncoder(passwordEncoder());
	}
	
}
