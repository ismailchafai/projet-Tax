package ma.zs.univ.integration.core.commun.rue;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class RueIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("RueHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
