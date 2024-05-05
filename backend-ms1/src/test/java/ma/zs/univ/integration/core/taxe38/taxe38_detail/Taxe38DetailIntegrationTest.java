package ma.zs.univ.integration.core.taxe38.taxe38-detail;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class Taxe38DetailIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("Taxe38DetailHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
