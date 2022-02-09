package com.project.cheapchap.service;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.cheapchap.model.Role;
import com.project.cheapchap.repository.RoleRepository;

@Service
public class RoleService {

	private RoleRepository roleRepository;
	
	public Role create(Role r) {
		return roleRepository.save(r);
	}
	
	public void delete(@PathVariable Long id) {
		Role r = roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role not found"));
		roleRepository.delete(r);
	}
}
