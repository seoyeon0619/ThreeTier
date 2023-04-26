package com.ds.business.repository;

import java.util.List;

import com.ds.data.dto.HobbyDto;


public interface HobbyDao {
	List<HobbyDto> getHobbyList(HobbyDto dto_h);
}
