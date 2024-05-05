package ma.zs.univ.integration.core.taxe38.taxe38;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class Taxe38IntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("Taxe38HappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
