package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Tourist;
import com.nt.service.ITouristMgmtService;

@RestController
@RequestMapping("/tourist")
public class TouristOperationsController {
	
	@Autowired
	private ITouristMgmtService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist){
		try {
			String resultMsg = service.register(tourist);
			return new ResponseEntity<String>(resultMsg, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<String>("Problem in Tourist Enrollement", 
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> displayTourists(){
		try {
			List<Tourist> list = service.getAllTourist();
			return new ResponseEntity<List<Tourist>>(list,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("Problem in Fetching Tourists", 
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
