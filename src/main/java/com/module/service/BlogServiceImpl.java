package com.module.service;

import com.module.model.Blog;
import com.module.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BlogServiceImpl implements BlogService {
  @Autowired
  BlogRepository blogRepository;

  @Override
  public List<Blog> findAll() {
    return blogRepository.findAll();
  }

//  @Override
//  public Page<Blog> findAll(Pageable pageable) {
//    return blogRepository.findAll(pageable);
//  }

  @Override
  public Blog findById(Integer id) {
    return blogRepository.findById(id);
  }

  @Override
  public void save(Blog blog) {
    blogRepository.save(blog);
  }

  @Override
  public void remove(Integer id) {
    blogRepository.remove(id);
  }
}
