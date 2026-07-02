package org.scoula.security.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResultDTO {
    // 로그인 성공 결과를 나타내는 응답
    // token & UserInfoDTO로 구성
    String token;
    UserInfoDTO user;
}
