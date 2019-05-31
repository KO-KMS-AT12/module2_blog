package com.module.repository;

import com.module.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogRepository {
  List<Blog> findAll();

//  Page<Blog> findAll(Pageable pageable);

  Blog findById(Integer id);

  void save(Blog blog);

  void remove(Integer id);
}
