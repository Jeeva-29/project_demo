package com.example.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.entity.DemoEntity;
import com.example.springdemo.service.DemoService;

@RestController
public class DemoController {
	@Autowired
	DemoService obj;
	@PostMapping("/save")
	public DemoEntity addDetails(@RequestBody DemoEntity obj3)
	{
		return obj.saveInfo(obj3);
	}
	@GetMapping("/fetch")
	public List<DemoEntity> getAllResttraining()
	{
		List<DemoEntity>listobj=obj.getAllDemoEntity();
		return listobj;
	}
	@PutMapping("/update")
	public DemoEntity mind(@RequestBody DemoEntity obj4)
	{
		return obj.update(obj4);
	}
	@DeleteMapping("/delete/{id}")
	public void  student(@PathVariable("id") int id)
	{
		obj.delete(id);
	}
	
	
	
	

}
	

 
