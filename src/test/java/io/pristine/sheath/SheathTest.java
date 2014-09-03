package io.pristine.sheath;

import dagger.Module;
import org.junit.After;
import org.junit.Test;

import java.lang.reflect.Field;

public class SheathTest {
    @Module
    class DummyModuleOne {

    }

    @Module
    class DummyModuleTwo {

    }

    @After
    public void tearDown() throws NoSuchFieldException, IllegalAccessException {
        Field objectGraph = Sheath.class.getDeclaredField("objectGraph");
        objectGraph.setAccessible(true);
        objectGraph.set(null, null);
    }

    @Test(expected = RuntimeException.class)
    public void holster_shouldThrowRuntimeExceptionWhenPassedNull() {
        Sheath.holster(null);
    }

    @Test
    public void plus_shouldAddModules() {
        Sheath.holster(new DummyModuleOne());
        Sheath.plus(new DummyModuleTwo());
    }

    @Test(expected = RuntimeException.class)
    public void plus_shouldThrowRuntimeExceptionIfHolsterNotCalled() {
        Sheath.plus(new DummyModuleOne());
    }

    @Test(expected = RuntimeException.class)
    public void inject_shouldThrowRuntimeExceptionIfHolsterNotCalled() {
        Sheath.inject(new Object());
    }

    @Test(expected = RuntimeException.class)
    public void injectStatics_shouldThrowRuntimeExceptionIfHolsterNotCalled() {
        Sheath.injectStatics();
    }

    @Test(expected = RuntimeException.class)
    public void validate_shouldThrowRuntimeExceptionIfHolsterNotCalled() {
        Sheath.validate();
    }

    @Test(expected = RuntimeException.class)
    public void get_shouldThrowRuntimeExceptionIfHolsterNotCalled() {
        Sheath.get(DummyModuleOne.class);
    }
}
