package runner;

/**
 * Created by kbrigida on 14.07.2017.
 */

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


/**
 * Created by tdvoryanchenko on 4/6/17.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = "src/test/resources/Calculator.feature",
        glue = "stepsMobile",
        format = {"json:path/to/cucumber.json"})

public class CalculatorRunner {
}
