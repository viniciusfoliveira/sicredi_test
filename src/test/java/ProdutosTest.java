import builder.LoginBuilder;
import builder.ProductBuilder;
import client.LoginClient;
import client.ProductClient;
import dto.LoginDTO;
import dto.ProductDTO;
import dto.RequisicaoDTO;
import enums.StatusCodeEnum;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.UtilsAmbiente;
import utils.UtilsExtentReport;
import utils.UtilsLerProperties;

import java.util.List;
import java.util.Map;

public class ProdutosTest {

    private static RequisicaoDTO requisicaoDTO = new RequisicaoDTO();

    @BeforeClass
    public static void efetuarLogin() {


        requisicaoDTO.setUrl(UtilsAmbiente.getAmbiente());

        LoginDTO loginDTO = LoginBuilder.efetuandoLogin();
        requisicaoDTO.setEndpoint("/auth/login");

        Response response = LoginClient.post(requisicaoDTO, loginDTO.getBodyLogin());
        JsonPath js = new JsonPath(response.asString());

        requisicaoDTO.setToken(js.get("token"));
        Assert.assertEquals(response.getStatusCode(), StatusCodeEnum.SUCCESS.getStatusCode());
        Assert.assertEquals(loginDTO.getUsername(), js.get("username"));

    }


    @Test
    public void buscarProdutoPorId() {

        try {
            requisicaoDTO.setUrl(UtilsAmbiente.getAmbiente());
            requisicaoDTO.setEndpoint("/products/{id}");
            Response response = ProductClient.getComParametro(requisicaoDTO, 1);

            JsonPath js = new JsonPath(response.asString());

            UtilsExtentReport.ExtentReport();
            UtilsExtentReport.sucess("Buscando produtos por ID");
            Assert.assertEquals(response.getStatusCode(), StatusCodeEnum.SUCCESS.getStatusCode());
            Assert.assertEquals(js.get("title"), "iPhone 9");

        } catch (Exception ex) {
            UtilsExtentReport.ExtentReport();
            UtilsExtentReport.fail("Buscando produtos por ID");

        }
    }

    @Test
    public void retornarProdutos() {

        try {
            requisicaoDTO.setUrl(UtilsAmbiente.getAmbiente());
            requisicaoDTO.setEndpoint("/products");
            Response response = ProductClient.get(requisicaoDTO);

            JsonPath js = new JsonPath(response.asString());

            List<Map<Object, Object>> users = (List<Map<Object, Object>>) js.get("products");

            UtilsExtentReport.ExtentReport();
            UtilsExtentReport.sucess("Retornar produtos");

            Assert.assertEquals(response.getStatusCode(), StatusCodeEnum.SUCCESS.getStatusCode());
            Assert.assertTrue(users.size() > 0);
        } catch (Exception ex) {

            UtilsExtentReport.ExtentReport();
            UtilsExtentReport.fail("Retornar produtos");
        }
    }

    @Test
    public void retornarProdutosComAutentificacao() {

        try {

            requisicaoDTO.setUrl(UtilsAmbiente.getAmbiente());
            requisicaoDTO.setEndpoint("/products");
            Response response = ProductClient.getToken(requisicaoDTO);

            JsonPath js = new JsonPath(response.asString());

            List<Map<Object, Object>> users = (List<Map<Object, Object>>) js.get("products");

            UtilsExtentReport.ExtentReport();
            UtilsExtentReport.sucess("Retornar produtos com autentificação");

            Assert.assertEquals(response.getStatusCode(), StatusCodeEnum.SUCCESS.getStatusCode());
            Assert.assertTrue(users.size() > 0);
        } catch (Exception ex) {
            UtilsExtentReport.ExtentReport();
            UtilsExtentReport.fail("Retornar produtos com autentificação");
        }
    }


    @Test
    public void inserirProdutos() {

        try {
            requisicaoDTO.setUrl(UtilsAmbiente.getAmbiente());
            ProductDTO productDTO = ProductBuilder.inserindoProduto();
            requisicaoDTO.setEndpoint("/products/add");
            Response response = ProductClient.post(requisicaoDTO, productDTO.getBodyProduto());

            JsonPath js = new JsonPath(response.asString());

            UtilsExtentReport.ExtentReport();
            UtilsExtentReport.sucess("Inserir produtos");

            Assert.assertEquals(response.getStatusCode(), StatusCodeEnum.SUCCESS.getStatusCode());
            Assert.assertEquals(productDTO.getTitle(), js.get("title"));
        } catch (Exception ex) {
            UtilsExtentReport.ExtentReport();
            UtilsExtentReport.fail("Inserir produtos");
        }
    }
}
