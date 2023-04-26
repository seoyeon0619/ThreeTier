package com.ds.business.repository;

import java.util.List;

import com.ds.data.dto.EmpHobbyDto;


public interface EmpHobbyDao {
	List<EmpHobbyDto> getEmpHobbyList(EmpHobbyDto dto_eh);
	List<EmpHobbyDto> getEmpHobbyView(EmpHobbyDto dto_eh);
	void insert_eh(EmpHobbyDto dto_eh);
	void update_eh(EmpHobbyDto dto_eh);
	void delete_eh(EmpHobbyDto dto_eh);
}
