package ma.zs.univ.integration.core.taxe38.taux-taxe38;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class TauxTaxe38IntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("TauxTaxe38HappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
