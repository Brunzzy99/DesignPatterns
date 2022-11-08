package singleton;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class SingletonTest {
    @Test
    public void testClassSingleton() {
        ClassSingleton classSingleton1 = ClassSingleton.getInstance();
        assert classSingleton1.getInfo().equals("Initial class info");
        ClassSingleton classSingleton2 = ClassSingleton.getInstance();
        classSingleton2.setInfo("New class info");
        assert classSingleton1.getInfo().equals("New class info");
        assert classSingleton2.getInfo().equals("New class info");
    }

    @Test
    public void testEnumSingleton() {
        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE.getInstance();
        assert enumSingleton1.getInfo().equals("Initial enum info");
        EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE.getInstance();
        enumSingleton2.setInfo("New enum info");
        assert enumSingleton1.getInfo().equals("New enum info");
        assert enumSingleton2.getInfo().equals("New enum info");
    }
}
