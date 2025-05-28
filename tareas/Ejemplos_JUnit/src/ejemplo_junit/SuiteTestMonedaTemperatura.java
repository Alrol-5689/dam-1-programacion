package ejemplo_junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestMoneda.class, TestTemperatura.class })
public class SuiteTestMonedaTemperatura {

}
