package ma.zs.univ.integration.core.commun.secteur;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class SecteurIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("SecteurHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
