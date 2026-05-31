package tests;

import com.automation.apps.Calculator;
import com.automation.hook.BaseMobileEngine;
import org.testng.annotations.Test;

public class MobileTest extends BaseMobileEngine {

    @Test
    public void calculator(){
        new Calculator().calculateExpression();
    }

}
