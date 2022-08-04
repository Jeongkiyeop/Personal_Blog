package com.sparta.personal_blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SignupRequestDto {
    private Long id;

    private String nickname;

    private String password;

    private String passwordConfirm;
}
