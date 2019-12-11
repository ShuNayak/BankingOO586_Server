package com.api.comp586.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.api.comp586.entity.Users;
import com.api.comp586.models.AuthenticationRequest;
import com.api.comp586.models.AuthenticationResponse;
import com.api.comp586.service.MyUserDetailsService;
import com.api.comp586.sevice.UsersService;
import com.api.comp586.util.JwtUtil;

import sun.misc.Contended;


@RequestMapping("User")
@RestController
public class UsersController  {

	@Autowired
	UsersService usersService;
	
	@Autowired
	private AuthenticationManager authManager ;
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private JwtUtil jwtutil;
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping("/register")
	public ResponseEntity<Users> userRegister(@RequestBody Users user) {
		return new ResponseEntity<Users>(usersService.registerUser(user), HttpStatus.OK);
	}
	
	@CrossOrigin("http://localhost:4200")
	@PutMapping("/update")
	public ResponseEntity<Users> updateUserData(@RequestBody Users user) {
		return new ResponseEntity<Users>(usersService.updateUserDetails(user), HttpStatus.OK);
	}
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/display/{userId}")
	public ResponseEntity<Users> displayUserDetails(@PathVariable(name="userId")String userId) {
		int userIdValue = Integer.parseInt(userId);
		return new ResponseEntity<Users>(usersService.displayUserdetails(userIdValue), HttpStatus.OK);
	}
	
	  @CrossOrigin("http://localhost:4200")
	@GetMapping("/all")
	public ResponseEntity<List<Users>> getAllUsers(){
		return new ResponseEntity<List<Users>>(usersService.displayAllUsers(), HttpStatus.OK);
	}
	
    @CrossOrigin("http://localhost:4200")
	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest authRequest) throws Exception {
		try{
			authManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		}catch(BadCredentialsException e) {
			throw new Exception("Incorrect userName or password",e);
		}
		final UserDetails userDetails  =  myUserDetailsService.loadUserByUsername(authRequest.getUserName());
		final String jwt = jwtutil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
    
  
   
}
