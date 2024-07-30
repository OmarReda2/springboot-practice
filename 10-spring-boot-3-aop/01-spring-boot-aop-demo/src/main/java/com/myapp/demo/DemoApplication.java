package com.myapp.demo;

import com.myapp.demo.dao.AccountDAO;
import com.myapp.demo.dao.MembershipDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, final MembershipDAO theMembershipDAO){
		return runner -> {
			demoTheBeforeAdvice(TheAccountDAO, theMembershipDAO);
		};
	}


	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO){

		// call the business methode
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// call the membership business methode
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();


	}
}
