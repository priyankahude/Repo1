package com.nt.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Plan_Category")
@Data
public class PlanCategory {
	@Id
	@SequenceGenerator(name="gen1",sequenceName="category_seq",initialValue=1,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	@Column(name="Category_ID")	
private Integer categoryId;
	@Column(name="Category_Name" , length=30)	
private String categoryName;
	@Column(name="Active_Switch", length=30)	
private String activeSwitch="active";
	@Column(name="Created_Date",updatable=false)	
private LocalDateTime createdDate;
	@Column(name="Updated_Date", updatable=true,insertable=false)	
private LocalDateTime updatedDate;
	@Column(name="Created_By" ,length=30)	
private String createdB;
	@Column(name="Update_By", length=30)	
private String updatedBy;

	
}
