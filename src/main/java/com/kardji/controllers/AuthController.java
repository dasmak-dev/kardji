package com.kardji.controllers;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kardji.controllers.dto.ResponseLoginDto;
import com.kardji.controllers.dto.UserLoginDto;
import com.kardji.models.entity.Usuarios;
import com.kardji.models.services.UsuarioServiceImpl;
import com.kardji.security.SecurityConstants;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UsuarioServiceImpl usersService;
	
	@PostMapping("/login")
	public ResponseEntity<ResponseLoginDto> login(@RequestBody UserLoginDto userLogin) throws NoSuchAlgorithmException {
		
		Usuarios user = usersService.login(userLogin.getName(), userLogin.getPassword());
		
		if(user != null) {
			return ResponseEntity.ok().body(new ResponseLoginDto(getToken(user)));
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
	}
	
	private String getToken(Usuarios user) {	
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("name", user.getName());
		data.put("authorities", Arrays.asList("ROLE_USER"));
		
		String token = Jwts.builder().setId("springEventos")
				.setSubject(user.getName()).addClaims(data)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 6000000))
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET_KEY).compact();
		
		return token;
	}
	

}
