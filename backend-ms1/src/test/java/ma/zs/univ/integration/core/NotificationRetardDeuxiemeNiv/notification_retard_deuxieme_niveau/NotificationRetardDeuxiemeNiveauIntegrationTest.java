package ma.zs.univ.integration.core.NotificationRetardDeuxiemeNiv.notification-retard-deuxieme-niveau;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class NotificationRetardDeuxiemeNiveauIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("NotificationRetardDeuxiemeNiveauHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
