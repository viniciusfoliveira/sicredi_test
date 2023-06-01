package client;

import dto.RequisicaoDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestClient {

    public static Response get(RequisicaoDTO requisicao) {
        return baseUrl(requisicao.getUrl())
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
