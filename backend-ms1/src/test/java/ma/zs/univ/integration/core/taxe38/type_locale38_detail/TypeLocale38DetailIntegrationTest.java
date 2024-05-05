package ma.zs.univ.integration.core.taxe38.type-locale38-detail;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class TypeLocale38DetailIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("TypeLocale38DetailHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
