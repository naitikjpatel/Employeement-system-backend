package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Emp;
import com.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpRepository empRepository;
	
	@Override
	public Emp createEmp(Emp emp) {
		// TODO Auto-generated method stub
		return empRepository.save(emp);
	}

	@Override
	public List<Emp> getAllEmp() {
	 return	empRepository.findAll();
	
	}

	@Override
	public Emp getEmpById(Integer id) {
	Optional<Emp> op=empRepository.findById(id);
	if(op.isEmpty())
		return null;
	else
		return op.get();
	}

	@Override
	public void deleteEmp(Integer id) {
	Emp emp=	empRepository.findById(id).get();
	if(emp!=null)
		empRepository.delete(emp);
		
	}

	@Override
	public Emp updateEmp(Integer id,Emp emp) {
	 Emp oldEmp=	empRepository.findById(id).get();
	 if(oldEmp!=null) {
		 emp.setId(id);
		  return empRepository.save(emp);
		 
	 }
	 else
		return null;
	}


}
