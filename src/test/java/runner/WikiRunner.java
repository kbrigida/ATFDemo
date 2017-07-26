package runner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import steps.Hooks;

import java.io.IOException;

import static steps.Hooks.driver;


@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"src/test/resources/Wiki.feature","src/test/resources/Second.feature"},
        glue = "steps",
        format = {"json:path/to/cucumber.json"})
public class WikiRunner extends Hooks {
    @BeforeClass
    public static void setup() {
        System.out.println("Run stated");
    }

    @AfterClass
    public static void teardown() throws IOException {
        System.out.println("Run finished. Driver should close");
        driver.quit();
        reportGeneration();
    }
}
