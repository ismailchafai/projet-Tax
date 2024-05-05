package ma.zs.univ.integration.core.NotificationRetardDeuxiemeNiv.notification-retard-deuxieme-niveau-detail-type38;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class NotificationRetardDeuxiemeNiveauDetailType38IntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("NotificationRetardDeuxiemeNiveauDetailType38HappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
