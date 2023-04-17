package helpers;

import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {
    public static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class);

    public static String getVideoUrl(String sessionId) {
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .log().all()
                .filter(withCustomTemplates())
                .auth().basic(config.getUser(), config.getKey())
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}