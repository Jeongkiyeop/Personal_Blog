package com.sparta.personal_blog.repository;

import com.sparta.personal_blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
