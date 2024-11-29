package com.jobportal.Jobportal.repository;

import com.jobportal.Jobportal.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String>
{

}
