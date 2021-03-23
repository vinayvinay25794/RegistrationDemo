package com.example.Hibernate.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Hibernate.Pojo.User;

@Repository
public interface AdminDao extends JpaRepository<User, Long>{
	

}
