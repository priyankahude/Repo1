package com.nt.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Travel_Plan")
@Data
public class TravelPlan {
	@Id
	@Column(name="Plan_ID")	
	@GeneratedValue(strategy=GenerationType.AUTO)
	
private Integer PlanID;
	@Column(name="Plan_Name" , length=30)	
private LocalDateTime PlanName;	
	@Column(name="Plan_Budget" , length=30)	
private LocalDateTime PlanBudget;
	@Column(name="Plan_Description",  length=50)	
private LocalDateTime PlanDescription;
	@Column(name="Plan_Category_ID")	
private Integer PlanCategoryID;
	private LocalDateTime createdDate;
	@Column(name="Updated_Date", updatable=true,insertable=false)	
private LocalDateTime updatedDate;
	@Column(name="Created_By" ,length=30)	
private String createdB;
	@Column(name="Update_By", length=30)	
private String updatedBy;
	@Column(name="Active_Switch",length=20)
	private String ActiveSW="active";
}
