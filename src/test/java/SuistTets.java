import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import utils.UtilsExtentReport;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ProdutosTest.class,
        UsuariosTest.class})
public class SuistTets {

    @AfterClass
    public static void eachCenario (){
        UtilsExtentReport.fecharCenario();
    }
}
