package client;

import dto.RequisicaoDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class ProductClient {

    public static Response post(RequisicaoDTO requisicao, Map<Object, Object> body) {
        return baseUrl(requisicao.getUrl())
                .when()
                .body(body)
                .post(requisicao.getEndpoint());
    }

    public static Response get(RequisicaoDTO requisicao) {
        return baseUrl(requisicao.getUrl())
                .when()
                .get(requisicao.getEndpoint());
    }

    public static Response getComParametro(RequisicaoDTO requisicao, Integer id) {
        return baseUrl(requisicao.getUrl())
                .pathParam("id", id)
                .when()
                .get(requisicao.getEndpoint());
    }

    public static Response getToken(RequisicaoDTO requisicao) {
        return baseUrl(requisicao.getUrl())
                .header("Authorization", requisicao.getToken())
                .when()
                .get(requisicao.getEndpoint());
    }

    private static RequestSpecification baseUrl(String url){
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .baseUri(url);
    }
}
