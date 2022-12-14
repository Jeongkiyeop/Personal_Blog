package com.sparta.personal_blog.service;

import com.sparta.personal_blog.dto.PostRequestDto;
import com.sparta.personal_blog.model.Post;
import com.sparta.personal_blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    @Transactional
    public Long update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id가 존재하지 않습니다.")
        );
        post.update(requestDto);
        return post.getId();
    }

    public String checkPassword(Long id, String password) {
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isEmpty()) {
            return "아이디 없음";
        }

        Post post = optionalPost.get();

        if (post.getPassword().equals(password)) {
            return "비밀번호 불일치";
        }
        return "success";
    }

}