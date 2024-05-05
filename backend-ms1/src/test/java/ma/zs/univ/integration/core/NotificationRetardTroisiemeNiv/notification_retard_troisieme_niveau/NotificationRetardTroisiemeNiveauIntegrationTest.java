package ma.zs.univ.integration.core.NotificationRetardTroisiemeNiv.notification-retard-troisieme-niveau;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class NotificationRetardTroisiemeNiveauIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("NotificationRetardTroisiemeNiveauHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
