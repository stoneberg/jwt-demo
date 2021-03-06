package com.stone.rest.play.user.payload;

import com.stone.rest.play.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UserRes {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginUserDto {
        private String username;
        private String email;

        public LoginUserDto(User user) {
            this.username = user.getUsername();
            this.email = user.getEmail();
        }
    }
}
