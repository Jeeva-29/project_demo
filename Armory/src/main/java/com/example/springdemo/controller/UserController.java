package com.example.springdemo.controller;



import java.util.List;
import java.util.Optional;
import java.util.Map;
   
import com.example.springdemo.service.UserService;
import com.example.springdemo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	public UserService service;
	
	
	//Sign Up Method
	@PostMapping(value = "/signup")
	public String signUp(@RequestBody UserEntity user){
		return service.createUser(user);
	}
	
	
	//Login Method
	@PostMapping(value = "/login")
	public String login(@RequestBody Map<String , String> loginData) {
		String username = loginData.get("userName");
		String password = loginData.get("password");
		
		return service.checkUser(username, password);
	}
	
	
	//Get User by Id
	@GetMapping(value = "/showUser")
	public Optional<UserEntity> getUserByReqParam(@RequestParam int user_id){
		return service.getUser(user_id);
	}
	
	
	//Get All Users
	@GetMapping(value = "/showUsers")
	public List<UserEntity> getAllUsers(){
		return service.getUsers();
	}
	
	
	//Update User By Id
	@PutMapping(value = "/editUser")
	public  String updateUserById(@RequestBody UserEntity user, @RequestParam(required = true) int id){
		return service.updateUser(user, id);
	}
	
	
	//Delete User By Id
	@DeleteMapping(value = "/deleteUser/{user_id}")
	public String deleteUserByReqParam(@RequestParam(required = true) int user_id){
		service.deleteUser(user_id);
		return "Drug with ID " + user_id + " is deleted"; 
	}
	
	
	//Ascending Sorting
	@GetMapping(value = "/sortAsc")
	public List<UserEntity> sortAsc(@RequestParam(required = true) String field){
		return service. sortAscending(field);
	}
	
	
	//Descending Sorting
	@GetMapping(value = "/sortDesc/{userName}")
	public List<UserEntity> sortDesc(@RequestParam(required = true) String field){
		return service. sortDescending(field);
	}
	
	
	//Pagination with sorting
	@GetMapping(value = "/pagination")
	public List<UserEntity> paginationData(@RequestParam(value = "pnu", required = true) int pnu, @RequestParam(value = "psize", required = true) int psize, @RequestParam(value = "field", required = true) String field){
		return service.paginationAndSorting(pnu, psize, field);
	}
}