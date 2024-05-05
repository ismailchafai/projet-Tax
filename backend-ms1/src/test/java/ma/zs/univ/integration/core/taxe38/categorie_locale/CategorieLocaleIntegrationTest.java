package ma.zs.univ.integration.core.taxe38.categorie-locale;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class CategorieLocaleIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("CategorieLocaleHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
