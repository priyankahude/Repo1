package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.entity.CoronaVaccine;
import com.nt.service.ICoronaVaccineMgmtService;

import ch.qos.logback.core.net.SyslogOutputStream;

@SpringBootApplication
public class SpringDataJpaApplication {
	
	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(SpringDataJpaApplication.class, args);
	
}
}