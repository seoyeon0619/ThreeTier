package com.ds.business.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ds.data.dto.HobbyDto;



@Repository("hobbyDao")
public class HobbyDaoImpl implements HobbyDao{
	
	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<HobbyDto> getHobbyList(HobbyDto dto_h){
		
		return sm.selectList("Hobby_getList");
	}
	
	
	

	
}
