import client.TestClient;
import client.UserClient;
import dto.RequisicaoDTO;
import enums.StatusCodeEnum;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utils.UtilsAmbiente;
import utils.UtilsExtentReport;

import java.util.List;
import java.util.Map;

public class UsuariosTest {

    private static RequisicaoDTO requisicaoDTO = new RequisicaoDTO();

    @Test
    public void testandoApi() {


        try {
            requisicaoDTO.setUrl(UtilsAmbiente.getAmbiente());
            requisicaoDTO.setEndpoint("/test");
            Response response = TestClient.get(requisicaoDTO);

            JsonPath js = new JsonPath(response.asString());


            UtilsExtentReport.ExtentReport();

            UtilsExtentReport.sucess("Teste API");
            Assert.assertEquals(response.getStatusCode(), StatusCodeEnum.SUCCESS.getStatusCode());
            Assert.assertEquals(js.get("status"), "ok");
            Assert.assertEquals(js.get("method"), "GET");
        }
        catch(Exception ex){
            UtilsExtentReport.ExtentReport();
            UtilsExtentReport.fail("Teste Api");
        }
    }

    @Test
    public void retornarUsuarios() {


       try {
           requisicaoDTO.setUrl(UtilsAmbiente.getAmbiente());
           requisicaoDTO.setEndpoint("/users");
           Response response = UserClient.get(requisicaoDTO);

           JsonPath js = new JsonPath(response.asString());

           List<Map<Object, Object>> users = (List<Map<Object, Object>>) js.get("users");

           UtilsExtentReport.ExtentReport();
           UtilsExtentReport.sucess("Retornando usuario");
           Assert.assertEquals(response.getStatusCode(), StatusCodeEnum.SUCCESS.getStatusCode());
           Assert.assertTrue(users.size() > 0);

       }
       catch(Exception ex){
           UtilsExtentReport.ExtentReport();
           UtilsExtentReport.fail("Retornando usuario");
       }
    }
}
