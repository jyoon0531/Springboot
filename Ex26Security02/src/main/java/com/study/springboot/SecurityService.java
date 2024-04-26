package com.study.springboot;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityService implements UserDetailsService {
    // 사용자 아이디를 통해, 사용자 정보와 권한을 스프링 시큐리티에 전달해준다.

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<>();
        // 테스트로 ADMIN 권한/역할을 넣어준다.
        authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        // username(아이디) : hong
        // password : "1234" 문자열을 Bcrypt 사이트(bycrypt-generator.com)에서 암호 생성해서 넣는다.
        return new User("hong", "$2a$16$3mKKKZSNuetRRChQVn.iz.MGqfKHztf5t5VwtkBPk3a34RyJcSvd2", authorities);
    }
}
