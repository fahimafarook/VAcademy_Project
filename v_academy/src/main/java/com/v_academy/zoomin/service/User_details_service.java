package com.v_academy.zoomin.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.v_academy.zoomin.model.User_details;

public interface User_details_service {
	
	 public List<User_details>service_get_user_logging(String name, String password);
	 public List<User_details>service_does_user_exist(String name);
	 List<User_details> get_entire_table();
	 User_details get_row_by_id(long id);
	 void save_row(User_details user);
	 void delete_row(long id);
	 Page<User_details>findPaginated(int page_no,int page_zise,String sort_field,String sort_direction);

	
     
}
