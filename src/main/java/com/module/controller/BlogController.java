package com.module.controller;

import com.module.model.Blog;

import com.module.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {

  @Autowired
  BlogService blogService;

  @GetMapping("/show")
  public ModelAndView show() {
    ModelAndView modelAndView = new ModelAndView("/blog/blog_page");
    List<Blog> blogList = blogService.findAll();
    modelAndView.addObject("blogPage", blogList);

    return modelAndView;
  }

//  @GetMapping("/shows")
//  public ModelAndView listCustomers(Pageable pageable){
//    Page<Blog> blogs = blogService.findAll(pageable);
//    ModelAndView modelAndView = new ModelAndView("/blog/blog_page");
//    modelAndView.addObject("blogPage", blogs);
//    return modelAndView;
//  }

  @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
  public ModelAndView delete(@PathVariable("id") int id) {
    blogService.remove(id);

    return new ModelAndView("redirect:/blog/show");
  }

  @GetMapping("/add")
  public ModelAndView add() {
    ModelAndView modelAndView = new ModelAndView("/blog/blog_form");
    Blog blog = new Blog();
    modelAndView.addObject("blogForm", blog);

    return modelAndView;
  }

  @GetMapping("/edit/{id}")
  public ModelAndView edit(@PathVariable("id") Integer id) {
    ModelAndView modelAndView = new ModelAndView("/blog/blog_form");
    Blog blog = blogService.findById(id);
    modelAndView.addObject("blogForm", blog);

    return modelAndView;
  }


  @GetMapping("/detail/{id}")
  public ModelAndView detail(@PathVariable("id") Integer id) {
    ModelAndView modelAndView = new ModelAndView("/blog/blog_detail");
    Blog blogDetail = blogService.findById(id);
    modelAndView.addObject("blogDetail", blogDetail);

    return modelAndView;
  }

  @PostMapping("/save")
  public ModelAndView save(@ModelAttribute("blogForm") Blog blog) {
    blogService.save(blog);
    return new ModelAndView("redirect:/blog/show");
  }
}
