package com.example.springAPI.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.example.springAPI.models.CreateData;
import com.example.springAPI.repo.CreateDataRepo;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private CreateDataRepo rep;
	
	@PostMapping("/create_data")
	public ResponseEntity<CreateData> CreateData(@RequestBody CreateData data) {
		CreateData create=rep.save(data);
		return new ResponseEntity(create, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/delete_data/{id}")
	public ResponseEntity<CreateData> deleteData(@PathVariable int id){
		
        if (rep.existsById(id)) {
        	rep.deleteById(id);
            
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	
	
	
}
