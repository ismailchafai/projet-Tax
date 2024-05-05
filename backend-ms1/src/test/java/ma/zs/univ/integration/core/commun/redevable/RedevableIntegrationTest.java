package ma.zs.univ.integration.core.commun.redevable;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class RedevableIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("RedevableHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
