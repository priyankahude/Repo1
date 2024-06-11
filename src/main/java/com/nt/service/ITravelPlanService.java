package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.entity.TravelPlan;

public interface ITravelPlanService {

	public String registerTravelPlan(TravelPlan plan);//save
	public Map<Integer , String> getTravelPlanCategories();//for select operation return type as map as we want to return id and name so
	public List<TravelPlan> showAllTravelPlan();//for select operation 
	public TravelPlan showTravelPlanById(Integer PlanId);//for edit operation form launch
	public String updateTravelPlan(TravelPlan plan);// form submittion
	public String deleteTravelPlan(Integer planId);//for delete operation (hard deletion)
	public String changeTravelPlanStatus(Integer planID, String stauts);//for soft deletion
	
}
