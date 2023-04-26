package com.ds.business.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ds.business.repository.EmpDao;
import com.ds.data.dto.EmpDto;


@Service("empService")
public class EmpServiceImpl implements EmpService{
	

	@Resource(name="empDao")
	EmpDao dao;
	
	@Override
	public List<EmpDto> getEmpList(EmpDto dto){
		return dao.getEmpList(dto);
	}
	
	@Override
	public EmpDto getView(EmpDto dto) {
		return dao.getView(dto);
	}

	@Override
	public void insert(EmpDto dto) {
		dao.insert(dto);
	}

	@Override
	public void update(EmpDto dto) {
		dao.update(dto);
	}

	@Override
	public void delete(EmpDto dto) {
		dao.delete(dto);
	}

}
