package com.module.repository;

import com.module.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

public class BlogRepositoryImpl implements BlogRepository {

  @PersistenceContext
  private EntityManager em;

  @Override
  public List<Blog> findAll() {
    TypedQuery<Blog> query = em.createQuery("select b from Blog b", Blog.class);
    return query.getResultList();
  }

//  @Override
//  public Page<Blog> findAll(Pageable pageable) {
//    return null;
//  }

  @Override
  public Blog findById(Integer id) {
    TypedQuery<Blog> query = em.createQuery("select b from Blog b where  b.id=:id", Blog.class);
    query.setParameter("id", id);
    try {
      return query.getSingleResult();
    } catch (NoResultException e) {
      return null;
    }
  }

  @Transactional
  @Override
  public void save(Blog blog) {
    if (blog.getId() != null) {
      em.merge(blog);
    } else {
      em.persist(blog);
    }
  }

  @Transactional
  @Override
  public void remove(Integer id) {
    Blog blog = findById(id);
    if (blog != null) {
      em.remove(blog);
    }
  }
}
