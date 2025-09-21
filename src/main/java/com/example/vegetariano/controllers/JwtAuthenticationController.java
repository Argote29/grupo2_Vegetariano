package com.example.vegetariano.controllers;

import com.example.vegetariano.dtos.JwtRequestDTO;
import com.example.vegetariano.dtos.JwtResponseDTO;
import com.example.vegetariano.securities.JwtTokenUtil;
import com.example.vegetariano.servicesimplements.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {


}