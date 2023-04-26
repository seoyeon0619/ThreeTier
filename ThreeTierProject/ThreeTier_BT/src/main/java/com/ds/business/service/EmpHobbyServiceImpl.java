package com.ds.business.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ds.business.repository.EmpHobbyDao;
import com.ds.data.dto.EmpHobbyDto;

@Service("emphobbyService")
public class EmpHobbyServiceImpl implements EmpHobbyService{

	@Resource(name="emphobbyDao")
	EmpHobbyDao dao;
	
	@Override
	public List<EmpHobbyDto> getEmpHobbyList(EmpHobbyDto dto_eh) {
		return dao.getEmpHobbyList(dto_eh);
	}
	
	@Override
	public List<EmpHobbyDto> getEmpHobbyView(EmpHobbyDto dto_eh) {
		return dao.getEmpHobbyView(dto_eh);
	}
	
	@Override
	public void insert_eh(EmpHobbyDto dto_eh) {
		dao.insert_eh(dto_eh);
	}

	@Override
	public void update_eh(EmpHobbyDto dto_eh) {
		dao.update_eh(dto_eh);
	}

	@Override
	public void delete_eh(EmpHobbyDto dto_eh) {
		dao.delete_eh(dto_eh);
	}



}
