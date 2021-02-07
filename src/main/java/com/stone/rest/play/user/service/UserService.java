package com.stone.rest.play.user.service;

import com.stone.rest.play.common.exception.AuthenticationFailedException;
import com.stone.rest.play.common.exception.EmailDuplicationException;
import com.stone.rest.play.config.security.jwt.JwtUtil;
import com.stone.rest.play.user.domain.Role;
import com.stone.rest.play.user.domain.RoleCode;
import com.stone.rest.play.user.domain.User;
import com.stone.rest.play.user.payload.UserReq;
import com.stone.rest.play.user.payload.UserReq.RegisterDto;
import com.stone.rest.play.user.repository.RoleRepository;
import com.stone.rest.play.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    /**
     * 사용자 등록
     *
     * @return
     * @throws EmailDuplicationException
     */
    @Transactional
    public Long registerUser(RegisterDto registerDto) throws EmailDuplicationException {
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            throw new EmailDuplicationException(String.format("Email [%s] is already in use", registerDto.getEmail()));
        }
        String hashedPassword = passwordEncoder.encode(registerDto.getPassword());
        registerDto.setPassword(hashedPassword);
        User user = registerDto.toEntity();
        Role userRole = roleRepository.findByName(RoleCode.ROLE_USER);
        // Role guestRole = roleRepository.findByName(RoleCode.ROLE_GUEST);
        // user.addUserRoles(Arrays.asList(userRole, guestRole));
        user.addUserRoles(Collections.singletonList(userRole));
        return userRepository.save(user).getId();
    }

    /**
     * 사용자 인증 및 토큰 생성
     *
     * @param loginDto
     * @return
     * @throws UserNotFoundException
     * @throws AuthenticationFailedException
     */
//    public Map<String, Object> loginUser(UserReq.LoginDto loginDto) throws UsernameNotFoundException, AuthenticationFailedException {
//        // check user exists
//        User user = userRepository.findByEmail(loginDto.getEmail())
//                .orElseThrow(() -> new UsernameNotFoundException(String.format("User [%s] not exists", loginDto.getEmail())));
//
//        // check password correct
//        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
//            throw new AuthenticationFailedException();
//        }
//
//        //        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
////        String token = jwtUtil.generateToken(auth.getName(), customUserDetails);
//
//        // create jwt token and send to user
//        return jwtUtil.generateJwtToken(user.getUsername);
//    }


}
