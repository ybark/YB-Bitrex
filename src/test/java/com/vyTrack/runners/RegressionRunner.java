package com.vyTrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        // nothing
        features = "src/test/resources/features",
        glue = "com.vyTrack.step_definitions" ,
        dryRun = false,
//        tags="@test1",
        plugin = {"html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"

        }

)

public class RegressionRunner {

}
