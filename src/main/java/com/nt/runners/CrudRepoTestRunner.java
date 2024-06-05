package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.entity.CoronaVaccine;
import com.nt.service.ICoronaVaccineMgmtService;

import ch.qos.logback.core.net.SyslogOutputStream;
@Component
public class CrudRepoTestRunner implements CommandLineRunner {
	@Autowired
	private ICoronaVaccineMgmtService isc;
	@Override
	 public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*	try {
				Iterable<CoronaVaccine> listEntities = isc.fetchDetails(false, "price","name");
				listEntities.forEach(System.out::println);
						
			}
			catch(DataAccessException de) {
				de.printStackTrace();
			}
			*/
	try {
	isc.fetchDetailsByPageNo(2, 3, false, "price").forEach(System.out::println);
	}
	catch(DataAccessException de) {
		de.printStackTrace();
	}
	}
}
