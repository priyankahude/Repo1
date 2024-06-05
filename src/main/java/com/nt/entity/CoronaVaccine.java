package com.nt.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoronaVaccine implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long regNo;
	@Column(length=20)
private String name;
	@Column(length=20)
private String company;
	@Column(length=20)
private String Country;
private Double price;
private Integer requiredDoseCount;
}
