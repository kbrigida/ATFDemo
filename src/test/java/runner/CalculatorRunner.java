package runner;

/**
 * Created by kbrigida on 14.07.2017.
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import java.io.IOException;

import static steps.Hooks.driver;
import static stepsMobile.HooksMobile.reportGeneration;
import static stepsMobile.HooksMobile.stopServer;


@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = "src/test/resources/Calculator.feature",
        glue = "stepsMobile",
        format = {"json:path/to/cucumber.json"})

public class CalculatorRunner {
    @BeforeClass
    public static void setup() {
        System.out.println("Run stated");
    }

    @AfterClass
    public static void teardown() throws IOException {
        System.out.println("Run finished. Driver should close");
        reportGeneration();
        stopServer();
    }
}
