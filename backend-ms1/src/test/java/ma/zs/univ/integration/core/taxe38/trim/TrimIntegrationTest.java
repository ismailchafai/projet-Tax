package ma.zs.univ.integration.core.taxe38.trim;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class TrimIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("TrimHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
