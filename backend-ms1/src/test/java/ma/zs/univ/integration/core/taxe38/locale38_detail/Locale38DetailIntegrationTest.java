package ma.zs.univ.integration.core.taxe38.locale38-detail;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class Locale38DetailIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("Locale38DetailHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
