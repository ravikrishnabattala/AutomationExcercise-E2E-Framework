package tests;

import com.automation.apps.Calculator;
import com.automation.hook.BaseMobileEngine;
import com.automation.listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class MobileAppTest extends BaseMobileEngine {

    @Test
    public void calculator(){
        new Calculator().calculateExpression();
    }

}
