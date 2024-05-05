package ma.zs.univ.integration.core.NotificationRetardDeuxiemeNiv.notification-retard-deuxieme-niveau-detail;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class NotificationRetardDeuxiemeNiveauDetailIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("NotificationRetardDeuxiemeNiveauDetailHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
