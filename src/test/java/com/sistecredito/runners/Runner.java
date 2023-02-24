package com.sistecredito.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/features/",
        tags = "@GetStatusSquema",
        glue = {
                "com.sistecredito.stepsdefinitions.hook",
                "com.sistecredito.stepsdefinitions"
        },
        publish = true
)
public class Runner {
}
