package com.sparta.personal_blog.service;

import com.sparta.personal_blog.dto.ResponseDto;
import com.sparta.personal_blog.dto.SignupRequestDto;
import com.sparta.personal_blog.model.User;
import com.sparta.personal_blog.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //아이디 :
    @Transactional
    public ResponseDto<?> registerUser(@RequestBody SignupRequestDto requestDto){
        User user = new User(requestDto);
        Optional<User> optionalNickname = userRepository.findByNickname(requestDto.getNickname());
        if (optionalNickname.isPresent()){
            return ResponseDto.fail("OVERLAP_USER_NICKNAME", "NICKNAME_OVERLAP");
        }else if (!requestDto.getPassword().equals(requestDto.getPasswordConfirm())){
            return ResponseDto.fail("PASSWORDCONFIRM_INCONSISTENT","passwordconfirm isn't inconsistent");
        }else {
            userRepository.save(user);
            return ResponseDto.success(user);
        }
    }

}
