package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.GroupDTO;

public interface GroupService {
	public void addGroup(GroupDTO groupDTO);
	public void addGroups(List<GroupDTO> groupDTOs);
	public GroupDTO getGroup(Long id);
	public List<GroupDTO> getAllGroups();
	public void deleteGroup(Long id);
	public void deleteGroups(List<Long> ids);
	
	

}
