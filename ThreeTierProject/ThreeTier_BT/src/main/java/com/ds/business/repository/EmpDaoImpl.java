package com.ds.business.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ds.data.dto.EmpDto;


@Repository("empDao")
public class EmpDaoImpl implements EmpDao{
	
	@Autowired
	SqlSessionTemplate sm;

	@Override
	public List<EmpDto> getEmpList(EmpDto dto) {
		return sm.selectList("Emp_getList",dto);
	}

	@Override
	public EmpDto getView(EmpDto dto) {
		return sm.selectOne("Emp_getView", dto);
	}

	@Override
	public void insert(EmpDto dto) {
		sm.insert("Emp_insert", dto);
	}

	@Override
	public void update(EmpDto dto) {
		sm.update("Emp_update", dto);
	}

	@Override
	public void delete(EmpDto dto) {
		sm.delete("Emp_delete", dto);
	}

	

}
