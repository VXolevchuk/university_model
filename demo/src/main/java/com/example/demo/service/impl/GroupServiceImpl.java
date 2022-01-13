package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Model.Group;
import com.example.demo.dto.GroupDTO;
import com.example.demo.repos.GroupRepository;
import com.example.demo.service.GroupService;

public class GroupServiceImpl implements GroupService{
	private final GroupRepository groupRepository;

	public GroupServiceImpl(GroupRepository groupRepository) {
		super();
		this.groupRepository = groupRepository;
	}

	@Override
	public void addGroup(GroupDTO groupDTO) {
		if(groupRepository.existsByNumber(groupDTO.getNumber()))
			return;
		Group group = Group.fromDTO(groupDTO);
		groupRepository.save(group);
		
	}

	@Override
	public void addGroups(List<GroupDTO> groupDTOs) {
		groupDTOs.forEach((x) -> {
		    if(groupRepository.existsByNumber(x.getNumber())) {
			
		    } else {
		    	Group group = Group.fromDTO(x);
				groupRepository.save(group);
		    }
		});
		
	}

	@Override
	public GroupDTO getGroup(Long id) {
		Group group = groupRepository.getById(id);
		return group.toDTO();
	}

	@Override
	public List<GroupDTO> getAllGroups() {
		List<Group> groups = groupRepository.findAll();
		List<GroupDTO> groupDTOs = new ArrayList<GroupDTO>();
		groups.forEach((x) -> {
			GroupDTO groupDTO = x.toDTO();
			groupDTOs.add(groupDTO);
		});
		return groupDTOs;
	}

	@Override
	public void deleteGroup(Long id) {
		groupRepository.deleteById(id);
		
	}

	@Override
	public void deleteGroups(List<Long> ids) {
		ids.forEach((x) -> {
			groupRepository.deleteById(x);
		});	
	}
	
	

}
