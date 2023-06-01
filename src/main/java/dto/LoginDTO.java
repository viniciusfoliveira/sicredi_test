package dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class LoginDTO {

    private String username;
    private String password;

    private Map<Object, Object> bodyLogin = new HashMap<>();

    @Builder
    public LoginDTO(String username, String password) {

        this.username = username;
        this.password = password;

        bodyLogin.put("username", this.username);
        bodyLogin.put("password", this.password);
    }
}
