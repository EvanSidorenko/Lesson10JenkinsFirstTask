package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("systemProperties")
public class SystemPropertiesTest {
    @Test
    void Test1() {
        String browser = System.getProperty("browser");
        System.out.println(browser); //null
    }
    @Test
    void Test2() {
        System.setProperty("browser", "safari");
        String browser = System.getProperty("browser");
        System.out.println(browser); //null
    }
    @Test
    void Test3() {
        String browser = System.getProperty("browser", "opera");
        System.out.println(browser); //null
    }
    @Test
    void Test4() {
        System.setProperty("browser", "safari");
        String browser = System.getProperty("browser", "opera");
        System.out.println(browser); //null
    }
    @Test
    @Tag("Test5")
    void Test5() {
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "100");
        String browserSize = System.getProperty("browserSize", "1920x1080");

        System.out.println(browser);
        System.out.println(version);
        System.out.println(browserSize);
    }
    @Test
    void Test6() {
        System.out.println("I want to say: " + System.getProperty("anyText"));
    }
}
