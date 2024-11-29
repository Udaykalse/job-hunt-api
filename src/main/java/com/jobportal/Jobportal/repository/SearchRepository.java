package com.jobportal.Jobportal.repository;

import com.jobportal.Jobportal.model.Post;

import java.util.List;

public interface SearchRepository
{
    List<Post> findByText(String text);

//    List<Post> findbyText();
}
