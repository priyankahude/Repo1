package com.nt.ms;

import java.util.List;
import java.util.Map;

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

import com.nt.entity.TravelPlan;
import com.nt.service.ITravelPlanService;

@RestController
//global path completely optional
@RequestMapping("/travelplan/api")
public class TravelPlanController {
@Autowired
private ITravelPlanService travelplanService;
	
	@GetMapping("/categories")
	public ResponseEntity<?> showTravelPlanCategories(){
		try {
		Map<Integer,String> mapCategories = travelplanService.getTravelPlanCategories();
		return new ResponseEntity<Map<Integer, String>>(mapCategories,HttpStatus.OK );
		
		}
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<Map<Integer, String>>(HttpStatus.INTERNAL_SERVER_ERROR );
			
		}
	}
	@PostMapping("/register")
	public ResponseEntity<?> saveTourPlan(@RequestBody TravelPlan tp){
		try {
			String msg = travelplanService.registerTravelPlan(tp);
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
				
		}
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	@GetMapping("/all")
	public ResponseEntity<?> getAllTravellPlan(){
		try {
			List<TravelPlan> list= travelplanService.showAllTravelPlan();
			return new ResponseEntity<List<TravelPlan>>(list, HttpStatus.OK);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PutMapping("/update")
	public ResponseEntity<?> updateTravelPlan(@RequestBody TravelPlan tp){
		
		try {
			String msg = travelplanService.updateTravelPlan(tp);
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	@DeleteMapping("/delete/{PlanId}")
	public ResponseEntity<?> deletetravelplanbyID(@PathVariable Integer PlanId){
		try {
			String msg = travelplanService.deleteTravelPlan(PlanId);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
			
		}
	catch(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	@DeleteMapping("/delete/{PlanId}/{status}")
	public ResponseEntity<?> removeTravelPlanByPlanID(@PathVariable Integer PlanId, @PathVariable String status){
		
		try {
			String msg= travelplanService.changeTravelPlanStatus(PlanId, status);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
}
