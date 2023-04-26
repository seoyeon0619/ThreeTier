package com.ds.business.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ds.data.dto.DeptDto;



@Repository("deptDao")
public class DeptDaoImpl implements DeptDao{

	@Autowired
	SqlSessionTemplate sm;

	@Override
	public List<DeptDto> getDeptList(DeptDto dto_d) {
		return sm.selectList("Dept_getList");
	}

	

}
