package demo;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Test;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.cucumber.CucumberRunner;
import com.intuit.karate.cucumber.KarateStats;


@KarateOptions(tags = {"~@ignore"})
public class DemoTest extends TestBase {
    // this class will automatically pick up all *.feature files
    // in src/test/java/demo and even recurse sub-directories
    // even though the class name ends with 'Test', the maven 'pom.xml'
    // has set 'DemoTestParallel' to be the default 'test suite' for the whole project
	
	
}
