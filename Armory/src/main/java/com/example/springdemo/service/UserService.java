package com.example.springdemo.service;



import java.util.List;
import java.util.Optional;

import com.example.springdemo.entity.UserEntity; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.springdemo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	public UserRepository repo;
	
	
	public String createUser(UserEntity user){
		boolean value = repo.existsByUserNameAndPassword(user.getUserName(), user.getPassword());
		if(value == true){
			return "The user already exists. To enter the application please use login";
		}
		else{
			repo.save(user);
			return "A new user with the details " + user.toString() + " is created. Login to continue";
		}
	}
	
	
	public String checkUser(String username, String password){
		boolean value = repo.existsByUserNameAndPassword(username, password);
		boolean exist = repo.existsByUserName(username);
		
		if(exist == true) {
			if(value == true) {
				return "The User is successfully Logged in";
			}
			else {
				return "The user password is not correct. Login failed";
			}
		}
		else {
			return "The user is not found in database";
		}
	}
	
	
	public Optional<UserEntity> getUser(int user_id){
		boolean value = repo.existsById(user_id);
		if(value == true) {
			return repo.findById(user_id);
		}
		else {
			return null;
		}
	}
	
	
	public List<UserEntity> getUsers(){
		return repo.findAll();
	}
	
	
	public String updateUser(UserEntity user, int user_id){
		boolean value = repo.existsById(user_id);
		UserEntity dummy = repo.findById(user_id).orElse(null);
		if(value == true) {
			dummy.setAge(user.getAge());
			dummy.setEmail(user.getEmail());
			dummy.setFirstName(user.getFirstName());
			dummy.setLastName(user.getLastName());
			dummy.setPassword(user.getPassword());
			dummy.setPhoneNumber(user.getPhoneNumber());
			dummy.setUserName(user.getUserName());
			
			repo.saveAndFlush(dummy);
			
			return "The user details was successfully updated in the database";
		}
		else {
			return "The user details is not present in the database to be updated";
		}
	}
	
	
	public String deleteUser(int user_id){
		UserEntity value = repo.findById(user_id).orElse(null);
		if(value != null) {
			repo.deleteById(user_id);
			return "Item with id " + user_id + "is not deleted from the database";
		}
		else {
			return "Item with id " + user_id + "is not deleted as it's not present in Database";
		}
	}
	
	
	public List<UserEntity> sortAscending(String field){
		return repo.findAll(Sort.by(Direction.ASC, field));
	}
	
	
	public List<UserEntity> sortDescending(String field){
		return repo.findAll(Sort.by(Direction.DESC, field));
	}
	
	
	public List<UserEntity> paginationAndSorting(int pageNumber, int pageSize, String column_name){
		Page<UserEntity> user = repo.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(column_name).descending()));
		return user.getContent();
	}
}
