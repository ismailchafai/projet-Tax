package ma.zs.univ.integration.core.commun.locale;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class LocaleIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("LocaleHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
