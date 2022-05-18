package Stepdefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue= {"Stepdefinitions"},

plugin= {"pretty","junit:target/HtmlReports/report.xml"},monochrome = true
, tags="@Sanity005"
)
public class RunnerClass {
	
	

}
