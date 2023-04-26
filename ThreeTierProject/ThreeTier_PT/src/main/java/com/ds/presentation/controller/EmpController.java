package com.ds.presentation.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ds.business.service.DeptService;
import com.ds.business.service.EmpHobbyService;
import com.ds.business.service.EmpService;
import com.ds.business.service.HobbyService;
import com.ds.data.dto.DeptDto;
import com.ds.data.dto.EmpDto;
import com.ds.data.dto.EmpHobbyDto;
import com.ds.data.dto.HobbyDto;


@Controller
public class EmpController {
	
	@Resource(name="empService")
	EmpService empService;
	@Resource(name="deptService")
	DeptService deptService;
	@Resource(name="hobbyService")
	HobbyService hobbyService;
	@Resource(name="emphobbyService")
	EmpHobbyService emphobbyService;
	
	
	// 사용자 포털로 이동
	@RequestMapping(value = "/user")
	public String user_portal(EmpDto dto, HobbyDto dto_h, EmpHobbyDto dto_eh,Model model) {
		model.addAttribute("EmpDto", dto);
		model.addAttribute("EmpHobbyDto", dto_eh);
		
		return "/user";
	}
	
	// insert 값 저장
	@RequestMapping(value = "/user/save")
	public String save(EmpDto dto, DeptDto dto_d, EmpHobbyDto dto_eh) {
		empService.insert(dto);
		if (dto_eh.getHobby_cd().contains(",")) {
			String[] hobby_list = dto_eh.getHobby_cd().split(",");
				for (int i = 0; i < hobby_list.length; i++) {
					dto_eh.setHobby_cd(hobby_list[i]);
					emphobbyService.insert_eh(dto_eh);
				}
			}
		else {
			emphobbyService.insert_eh(dto_eh);
		}
		return "redirect:/admin";
	}
	
	// 관리자 포털로 이동
	@RequestMapping(value = "/admin")
	public String admin_portal(EmpDto dto, Model model) {
		model.addAttribute("searchKeyword", dto.getSearchKeyword());
		
		List<EmpDto> list = empService.getEmpList(dto);
		model.addAttribute("list", list);
		
		return "/admin_list";
	}
	
//	// 사용자 리스트 가져오기
//	@ModelAttribute("list")
//	public List<EmpDto> getEmpList(EmpDto dto, Model model){
//		List<EmpDto> list = empService.getEmpList(dto);
//		
//		return list;
//	}
	
	// 부서 리스트 가져오기
	@ModelAttribute("list_d")
	public List<DeptDto> getDeptList(DeptDto dto_d) {
		List<DeptDto> list_d = deptService.getDeptList(dto_d);
		return list_d;
	}
	
	// 취미 리스트 가져오기
	@ModelAttribute("list_h")
	public List<HobbyDto> getHobbyList(HobbyDto dto_h) {
		List<HobbyDto> list_h = hobbyService.getHobbyList(dto_h);
		
		return list_h;
	}
	
	@RequestMapping(value = "/admin/{emp_id}")
	public String getView(@PathVariable("emp_id") String emp_id, EmpDto dto, HobbyDto dto_h, EmpHobbyDto dto_eh, Model model) {
		model.addAttribute("searchKeyword", dto.getSearchKeyword());
		
		EmpDto resultDto = empService.getView(dto);
		model.addAttribute("dto", resultDto);
		
		List<EmpDto> list = empService.getEmpList(dto);
		model.addAttribute("list", list);

		List<HobbyDto> list_h = hobbyService.getHobbyList(dto_h);
		model.addAttribute("list_h", list_h);
		
		List<EmpHobbyDto> list_eh = emphobbyService.getEmpHobbyView(dto_eh);
		StringBuffer emp_hobby_list = new StringBuffer();
		for (int i = 0; i < list_eh.size(); i++) {
			emp_hobby_list.append(list_eh.get(i).getHobby_cd());
		}
		model.addAttribute("emp_hobby_list", emp_hobby_list);
		System.out.println(dto.getSearchKeyword());
		return "/admin_view";
	}
	
	@RequestMapping("/admin/update/{emp_id}")
	public String update(@PathVariable("emp_id") String emp_id, EmpDto dto, DeptDto dto_d, EmpHobbyDto dto_eh, Model model) {
		empService.update(dto);
		emphobbyService.update_eh(dto_eh);
		if (dto_eh.getHobby_cd().contains(",")) {
			String[] hobby_list = dto_eh.getHobby_cd().split(",");
				for (int i = 0; i < hobby_list.length; i++) {
					dto_eh.setHobby_cd(hobby_list[i]);
					emphobbyService.insert_eh(dto_eh);
				}
			}
		else {
			emphobbyService.insert_eh(dto_eh);
		}
		
		return "redirect:/admin"; 
	}
	
	@RequestMapping(value = "/admin/delete/{emp_id}")
	public String delete(EmpDto dto, Model model)
	{
		empService.delete(dto);
		return "redirect:/admin";
	}
	
	
	
	
	
	
	
	
	

	
	
	

	
	
	
}
