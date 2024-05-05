package ma.zs.univ.integration.core.commun.quartier;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class QuartierIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("QuartierHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
