package com.example.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.springdemo.entity.DemoEntity;
import com.example.springdemo.repository.DemoRepository;

@Service
public class DemoService {
	@Autowired
	DemoRepository obj1;
	public DemoEntity saveInfo(@RequestBody DemoEntity obj5)
	{
		return obj1.save(obj5);
	}
	public List<DemoEntity> getAllDemoEntity()
	{
		List<DemoEntity>listobj1=obj1.findAll();
		return listobj1;
	}
	public DemoEntity update(DemoEntity obj6)
	{
		return obj1.save(obj6);
	}
	public void delete(int id)
	{
		obj1.deleteById(id);
	}

}
	


