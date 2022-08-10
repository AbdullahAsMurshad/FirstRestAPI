package com.example.schedular;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class FirstSchedular {

	/*
	 * it  will do whatever business logic  I  write in the  method and will start  exectued  every minute
	 * cronmaker.com have been used  for  the cron making and currently  it  is  set to  every minute
	 * cron is  just  an expression which is to said when to execuute the block  of  code
	 */
	@Scheduled(cron = "0 0/1 * 1/1 * ?")
	public  void firstSchedular() {
		System.out.println(new Date());
	}
	
}
