package org.scoula.security.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.security.account.domain.MemberVO;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDTO {
    // 로그인 성공 시 응답에 포함시킬 사용자 정보
    // token, user{username, email, roles} 포함
    String username;
    String email;
    List<String> roles;

    public static UserInfoDTO of(MemberVO member){
        return new UserInfoDTO(
                member.getUsername(),
                member.getEmail(),
                member.getAuthList().stream()
                        .map(a -> a.getAuth())
                        .toList()
        );
    }
}
