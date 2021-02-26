package edu.bit.ex.encoder;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PWEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {

		return rawPassword.toString().equals(encodedPassword);
	}
	

}
