package com.v_academy.zoomin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.v_academy.zoomin.model.User_details;

@Repository
public interface User_datails_repository extends JpaRepository<User_details,Long> {
	
	@Query("SELECT ud FROM User_details ud WHERE ud.user_name= ?1 and ud.password=?2")
	public List<User_details>get_user_logging(String name ,String password);
	
	
	@Query("SELECT ud FROM User_details ud WHERE ud.user_name= ?1")
	public List<User_details> does_user_exist(String name);



}
