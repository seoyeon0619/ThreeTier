package com.ds.business.service;

import java.util.List;

import com.ds.data.dto.DeptDto;


public interface DeptService {
	List<DeptDto> getDeptList(DeptDto dto_d);
}
