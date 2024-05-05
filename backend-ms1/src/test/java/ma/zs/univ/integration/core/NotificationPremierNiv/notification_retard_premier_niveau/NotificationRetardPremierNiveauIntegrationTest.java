package ma.zs.univ.integration.core.NotificationPremierNiv.notification-retard-premier-niveau;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class NotificationRetardPremierNiveauIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("NotificationRetardPremierNiveauHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
