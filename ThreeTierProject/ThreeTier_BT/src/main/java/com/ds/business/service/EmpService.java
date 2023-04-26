package com.ds.business.service;


import java.util.List;

import com.ds.data.dto.EmpDto;


public interface EmpService {
	List<EmpDto> getEmpList(EmpDto dto);
	EmpDto getView(EmpDto dto);
	
	void insert(EmpDto dto);
	void update(EmpDto dto);
	void delete(EmpDto dto);
}
