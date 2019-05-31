package com.module.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "content", nullable = false,length = 4000)
  private String content;

  @Column(name = "author", nullable = false)
  private String author;

  @Column(name = "date", nullable = false)
  private String date;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }
}
