package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import domain.Actor;
import domain.Authority;
import domain.User;
import domain.UserAccount;
import repositories.RegistrationRepository;


@Service
@Transactional
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	public RegistrationService(){
		super();
	}
	
	/*--------------------CRUD-----------------------*/
	
	
	public User create(User user){
		
		if(!user.equals(null)){
			
			
			registrationRepository.save(user);
		}
		
		return user;
	}
	
	public User modify(User user){
		
		if(!user.equals(null)){
			Actor aux= registrationRepository.findById(user.getId()).get();
			aux.setAdress(user.getAdress());
			aux.setEmail(user.getEmail());
			aux.setName(user.getName());
			aux.setPhone(user.getPhone());
			aux.setSurname(user.getSurname());
			registrationRepository.save(aux);
		}
		
		return user;
	}
	
	public void assignAuthority(User user){
		Authority au;
		UserAccount userAccount;
		Collection<Authority> authorities;
		
		au = new Authority();
		userAccount = new UserAccount();
		authorities = new ArrayList<Authority>();
		
		userAccount.setAuthorities(authorities);
		au.setAuthority("USER");
		userAccount.addAuthority(au);
		user.setUserAccount(userAccount);
	}

}
