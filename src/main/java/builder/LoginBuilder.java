package builder;

import dto.LoginDTO;

public class LoginBuilder {

    private LoginBuilder(){}

    public static LoginDTO efetuandoLogin(){
        return LoginDTO.builder()
                .username("kminchelle")
                .password("0lelplR")
                .build();
    }
}
