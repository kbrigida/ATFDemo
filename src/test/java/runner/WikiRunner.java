package runner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


/**
 * Created by tdvoryanchenko on 4/6/17.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = "src/test/resources/Wiki.feature",
        glue = "steps",
        format = {"json:path/to/cucumber.json"})
public class WikiRunner {
}
