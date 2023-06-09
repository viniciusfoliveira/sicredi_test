package client;

import dto.RequisicaoDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class LoginClient {


    private LoginClient (){}

    public static Response post(RequisicaoDTO requisicao, Map<Object, Object> body) {
        return baseUrl(requisicao.getUrl())
                .when()
                .body(body)
                .post(requisicao.getEndpoint());
    }


    private static RequestSpecification baseUrl(String url){
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .baseUri(url);
    }
}
