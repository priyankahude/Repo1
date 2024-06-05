package com.nt.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.CoronaVaccine;
import com.nt.repo.ICoronaVaccineRepo;

@Service("VaccineMgmtService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService{
	@Autowired
private ICoronaVaccineRepo coronaRepo;
	@Override
	public Iterable<CoronaVaccine> fetchDetails(boolean asc, String...properties){
		Sort sort= Sort.by(asc?Direction.ASC:Direction.DESC, properties);
		Iterable<CoronaVaccine> listEntities= coronaRepo.findAll(sort);
		return listEntities;
		
		
	}
	@Override
	public Iterable<CoronaVaccine> fetchDetailsByPageNo(int PageNo,int PageSize,boolean asc,String...properties){
		//create pageable obj having inputs
		Pageable pageable = PageRequest.of(PageNo, PageSize, asc?Direction.ASC:Direction.DESC, properties);
		Page<CoronaVaccine> page = coronaRepo.findAll(pageable);
		return page.getContent();
	}
	/*@Override
	public void fetchDetailsbyPagination(int pageSize) {
		//get record
		long count= coronaRepo.count();
		int pageCount=count++
		*/
	@Override
	public void fetchDetailsbyPagination(int pageSize) {
		// TODO Auto-generated method stub
		
	}
		
		
	}


