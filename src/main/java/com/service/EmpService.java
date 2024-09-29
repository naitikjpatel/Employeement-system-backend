package com.service;

import java.util.List;

import com.entity.Emp;

public interface EmpService {

	public Emp createEmp(Emp emp);
	public List<Emp> getAllEmp();
	
	public Emp getEmpById(Integer id);
	public void deleteEmp(Integer id);
	
	public Emp updateEmp(Integer id,Emp emp);
	
}
