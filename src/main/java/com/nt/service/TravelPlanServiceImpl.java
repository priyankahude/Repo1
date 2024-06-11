package com.nt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.PlanCategory;
import com.nt.entity.TravelPlan;
import com.nt.repository.IPlanCategory;
import com.nt.repository.ITravelCategory;
@Service
public class TravelPlanServiceImpl implements ITravelPlanService {
	@Autowired()
	private ITravelCategory travelplan;
	@Autowired()
	private IPlanCategory plancategory;

	@Override
	public String registerTravelPlan(TravelPlan plan) {
//save the object
		TravelPlan saved= travelplan.save(plan);
		/*
		 * if(saved.getPlanID()==null) return "Travel plan is saved"+saved.getPlanID();
		 * else return "problem in saving Id";
		 */
		return saved.getPlanID()==null?"Travel Plan is saved::" +saved.getPlanID():"Problem in saving ID";
		
	}
	@Override
	public Map<Integer, String> getTravelPlanCategories() {
		//get all travel plan categories
		List<PlanCategory> list=plancategory.findAll();
		Map<Integer, String> categorymaped =new HashMap<Integer, String>();
		list.forEach(category->{
			categorymaped.put(category.getCategoryId(), category.getCategoryName());	
		});
		return categorymaped;
	}

	@Override
	public List<TravelPlan> showAllTravelPlan() {
		
		return travelplan.findAll();
	}

	@Override
	public TravelPlan showTravelPlanById(Integer PlanId) {
		Optional<TravelPlan> opt = travelplan.findById(PlanId);
		if(opt.isPresent())	
		return opt.get();
		else 
			throw new IllegalArgumentException("travel not found");
		
		/*
		 * return travelplan.findById(PlanId).orElseThrow(()->new
		 * IllegalArgumentException("travle not found"));
		 */
	}
	@Override
	public String updateTravelPlan(TravelPlan plan) {
	/*	TravelPlan updated= travelplan.save(plan);
		return updated.getPlanID()+"Travel plan is updated";*/
		
		Optional<TravelPlan>  opt=travelplan.findById(plan.getPlanID());
		if(opt.isPresent()) {
			return "id is present"+plan.getPlanID();
			}
			else
			{	
				return "id is not present";
				}
			
		}
	

	@Override
	public String deleteTravelPlan(Integer planId) {
		Optional<TravelPlan>  opt=travelplan.findById(planId);
		if(opt.isPresent()) {
			travelplan.deleteById(planId);
			return "id is present" +planId;
			}
			else
			{	
				return "id is not present";
				}
			
		}
	

	@Override
	public String changeTravelPlanStatus(Integer planID, String stauts) {
		Optional<TravelPlan> opt= travelplan.findById(planID);
		if(opt.isPresent()){
			TravelPlan plan = opt.get();
			plan.setActiveSW(stauts);
			travelplan.save(plan);
			return planID+"plan id";
			
		}
		else {
			return "travel plan id is not updated";
					
		}
		
	}

}
