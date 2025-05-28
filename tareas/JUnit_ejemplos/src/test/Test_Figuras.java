package test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ Test_Circulo.class, Test_Cuadrado.class })
public class Test_Figuras {

}
