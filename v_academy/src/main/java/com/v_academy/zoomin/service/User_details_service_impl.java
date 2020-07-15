package com.v_academy.zoomin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.v_academy.zoomin.model.User_details;
import com.v_academy.zoomin.repository.User_datails_repository;
@Service
public class User_details_service_impl implements User_details_service{
	
	@Autowired 
	private User_datails_repository repository_reference;
	
	@Override
	public List<User_details>service_get_user_logging(String name, String password) //custom querry
	{
		return repository_reference.get_user_logging(name,password);
	}
	
	@Override
	public List<User_details>service_does_user_exist(String name) //custom querry
	{
		return repository_reference.does_user_exist(name);
	}

	@Override
	public List<User_details> get_entire_table() {
		return repository_reference.findAll();
	}

	@Override
	public User_details get_row_by_id(long id) {
		Optional<User_details> optional = repository_reference.findById(id);
		User_details user = null;
		if (optional.isPresent()) {
		user = optional.get();
		} else {
		throw new RuntimeException(" no member such found :: " + id);
		}
		return user;
	}

	@Override
	public void save_row(User_details user) {
		this.repository_reference.save(user);
		
	}

	@Override
	public void delete_row(long id) {
		this.repository_reference.deleteById(id);
		
	}

	@Override
	public Page<User_details> findPaginated(int page_no, int page_size, String sort_field, String sort_direction) {
		Sort sort = sort_direction.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sort_field).ascending() :
			Sort.by(sort_field).descending();

			Pageable pageable = PageRequest.of(page_no - 1, page_size, sort);
			return this.repository_reference.findAll(pageable);	
	}

}
