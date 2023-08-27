package com.example.springAPI.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springAPI.models.CreateData;
import com.example.springAPI.repo.CreateDataRepo;
import com.mongodb.client.model.Collation;

@RestController
@RequestMapping("/reader")
public class ReaderController {
	private static final ArrayList<Object> Double = null;
	@Autowired
	private CreateDataRepo rep;
	
	//int N;
	
	@GetMapping("/get_data")
	public ResponseEntity<List<CreateData>> getAll() {
		 List<CreateData> dataList = rep.findAll();
		 
		 return new ResponseEntity<>(dataList, HttpStatus.OK);	 
		
        
    }
	
//	@GetMapping("/get_data/{id}")
//	public ResponseEntity<CreateData> getById(@PathVariable int id) {
//		 List<CreateData> dataList = rep.findAll();
//		 if (id < dataList.size()) {
//	         CreateData data = dataList.get(id);
//	         return new ResponseEntity<>(data, HttpStatus.OK);
//	     } else {
//	         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	     }
//    }
	
	@GetMapping("/get_dis")
	public List getByN() {
		 List<CreateData> dataList = rep.findAll();	
		 List<Double> dist=new ArrayList<>();
		 for (CreateData data : dataList) {
			 double lat= data.getLongitude();
			 double lon=data.getLatitude();
			 dist.add(getDistance(lat, lon));
		}
		 Collections.sort(dist);
		return dist;
	    
    }
	private double getDistance(double lat, double lon) {
		final double R=6371.0;
		lat= Math.toRadians(lat);
        lon=Math.toRadians(lon);


        double a = Math.pow(Math.sin(lat / 2), 2) + Math.cos(0) * Math.cos(lat) * Math.pow(Math.sin(lon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = Math.floor((R * c)*1000)/1000;

        return distance;
		
	}
	
	

}
