package com.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.model.DbModel;

public interface DbRepository extends JpaRepository<DbModel, Long>{
	List<DbModel> findByPublished(boolean published);
	List<DbModel> findByTitleContaining(String title);

}
