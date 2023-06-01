import builder.LoginBuilder;
import builder.ProductBuilder;
import client.LoginClient;
import client.ProductClient;
import client.TestClient;
import client.UserClient;
import dto.LoginDTO;
import dto.ProductDTO;
import dto.RequisicaoDTO;
import enums.StatusCodeEnum;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.UtilsLerProperties;

import java.util.List;
import java.util.Map;

public class RunnerTest {

    private static RequisicaoDTO requisicaoDTO = new RequisicaoDTO();

    @BeforeClass
    public static void efetuarLogin() {
        requisicaoDTO.setUrl(UtilsLerProperties.getProperties("api.url"));

        LoginDTO loginDTO = LoginBuilder.efetuandoLogin();
        requisicaoDTO.setEndpoint("/auth/login");

        Response response = LoginClient.post(requisicaoDTO, loginDTO.getBodyLogin());
        JsonPath js = new JsonPath(response.asString());

        requisicaoDTO.setToken(js.get("token"));

        Assert.assertEquals(response.getStatusCode(), StatusCodeEnum.SUCCESS.getStatusCode());
        Assert.assertEquals(loginDTO.getUsername(), js.get("username"));
    }


    @Test
    public void buscarProdutoPorId()
    {

        requisicaoDTO.setEndpoint("/products/{id}");
        Response response = ProductClient.getComParametro(requisicaoDTO, 1);

        JsonPath js = new JsonPath(response.asString());


        Assert.assertEquals(response.getStatusCode(), StatusCodeEnum.SUCCESS.getStatusCode());
        Assert.assertEquals(js.get("title"), "iPhone 9");

    }
    @Test
    public void testandoApi() {
        requisicaoDTO.setEndpoint("/test");
        Response response = TestClient.get(requisicaoDTO);

        JsonPath js = new JsonPath(response.asString());


        Assert.assertEquals(response.getStatusCode(), StatusCodeEnum.SUCCESS.getStatusCode());
        Assert.assertEquals(js.get("status"), "ok");
        Assert.assertEquals(js.get("method"), "GET");

    }

    @Test
    public void retornarUsuarios() {

        requisicaoDTO.setEndpoint("/users");
        Response response = UserClient.get(requisicaoDTO);

        JsonPath js = new JsonPath(response.asString());

        List<Map<Object, Object>> users = (List<Map<Object, Object>>) js.get("users");

        Assert.assertEquals(response.getStatusCode(), StatusCodeEnum.SUCCESS.getStatusCode());
        Assert.assertTrue(users.size() > 0);
    }

    @Test
    public void retornarProdutos() {

        requisicaoDTO.setEndpoint("/products");
        Response response = ProductClient.get(requisicaoDTO);

        JsonPath js = new JsonPath(response.asString());

        List<Map<Object, Object>> users = (List<Map<Object, Object>>) js.get("products");

        Assert.assertEquals(response.getStatusCode(), StatusCodeEnum.SUCCESS.getStatusCode());
        Assert.assertTrue(users.size() > 0);
    }

    @Test
    public void retornarProdutosComAutentificacao() {

        requisicaoDTO.setEndpoint("/products");
        Response response = ProductClient.getToken(requisicaoDTO);

        JsonPath js = new JsonPath(response.asString());

        List<Map<Object, Object>> users = (List<Map<Object, Object>>) js.get("products");

        Assert.assertEquals(response.getStatusCode(), StatusCodeEnum.SUCCESS.getStatusCode());
        Assert.assertTrue(users.size() > 0);
    }


    @Test
    public void inserirProdutos() {

        ProductDTO productDTO = ProductBuilder.inserindoProduto();

        requisicaoDTO.setEndpoint("/products/add");
        Response response = ProductClient.post(requisicaoDTO, productDTO.getBodyProduto());

        JsonPath js = new JsonPath(response.asString());


        Assert.assertEquals(response.getStatusCode(), StatusCodeEnum.SUCCESS.getStatusCode());
        Assert.assertEquals(productDTO.getTitle(), js.get("title"));

    }
}
