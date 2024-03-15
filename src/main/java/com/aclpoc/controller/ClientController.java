package com.aclpoc.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.server.csrf.CsrfToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aclpoc.dto.AuthRequest;
import com.aclpoc.dto.Client;
import com.aclpoc.jwt.JwtService;
import com.aclpoc.service.ClientService;


@RestController
@RequestMapping("api/v1/client")
public class ClientController implements ClientControllerInterface {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
    private JwtService jwtService; 
  
    @Autowired
    private AuthenticationManager authenticationManager; 

	private final ClientService clientService;

	public ClientController(@Qualifier("jpaService") ClientService clientService) {
		super();
		this.clientService = clientService;
	}

	/**
	 * Get list of Clients
	 * @return
	 */
	@Override
	@GetMapping
//	@PreAuthorize("hasAuthority('ROLE_ADMIN')")		// new method of verifying the role using SpEL
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	public ResponseEntity<List<Client>> getClients() {
		List<Client> clients = clientService.getClients();
		LOG.info("Inside controller function!");
		return ResponseEntity.ok(clients);
	}
	
	@Override
	@PostMapping
	public void createClient(String name, String location, LocalDate date) throws Exception {
		clientService.saveClient(new Client(name, location, date));
	}
	
	@Override
	@DeleteMapping
	public void deleteClientById(Long id) {
		clientService.deleteClientById(id);
	}
	
//	@GetMapping("/csrf")
//	public CsrfToken csrf(CsrfToken token) {
//		return token;
//	}
	
	@PostMapping("/generateToken") 
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())); 
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else { 
            throw new UsernameNotFoundException("Invalid User Request !"); 
        } 
    } 

	
}
