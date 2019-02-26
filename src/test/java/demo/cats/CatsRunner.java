package demo.cats;

import com.intuit.karate.KarateOptions;
import demo.TestBase;


@KarateOptions(features = "classpath:demo/cats/cats.feature")
public class CatsRunner extends TestBase {
    
}
