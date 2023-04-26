package com.ds.business.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ds.data.dto.EmpHobbyDto;


@Repository("emphobbyDao")
public class EmpHobbyDaoImpl implements EmpHobbyDao{

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<EmpHobbyDto> getEmpHobbyList(EmpHobbyDto dto_eh) {
		return sm.selectList("EmpHobby_getList", dto_eh);
	}
	
	@Override
	public List<EmpHobbyDto> getEmpHobbyView(EmpHobbyDto dto_eh) {
		return sm.selectList("EmpHobby_getView", dto_eh);
	}
	
	@Override
	public void insert_eh(EmpHobbyDto dto_eh) {
		sm.insert("EmpHobby_insert", dto_eh);
	}

	@Override
	public void update_eh(EmpHobbyDto dto_eh) {
		sm.update("EmpHobby_update", dto_eh);
	}

	@Override
	public void delete_eh(EmpHobbyDto dto_eh) {
		sm.delete("EmpHobby_delete", dto_eh);
	}



}
