package org.scoula.security.account.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;

import javax.servlet.http.HttpServletRequest;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
    // Sprint Security 규약에 따라 username, password 속성 가짐
    // Request Body의 json 문자열에서 LoginDTO 객체로 역직렬화 직접 수행
    private String username;
    private String password;

    public static LoginDTO of(HttpServletRequest request){
        ObjectMapper om = new ObjectMapper();
        try{
            return om.readValue(request.getInputStream(), LoginDTO.class);
        }catch (Exception e){
            e.printStackTrace();
            throw new BadCredentialsException("username 또는 password가 없습니다.");
        }
    }
}
