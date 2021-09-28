package com.bh.at.s1scout200.step;

import com.bh.at.s1scout200.tester.*;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class CucumberHooks {

    private BaseTester baseTester = new BaseTester();
    private static final HomeTester homeTester=new HomeTester();
    private static final SettingTester settingTester=new SettingTester();
    private static final DevicesTester devicesTester=new DevicesTester();
    private static final MeasureTester measureTester=new MeasureTester();
    private static final SensorConfigTester sensorConfigTester=new SensorConfigTester();

    @After
    public void endCase(Scenario scenario)
    {
        if (scenario.isFailed()) {
            System.out.println("Scenario Failed :--"+scenario.getName());

            // homeTester.appBack();
            baseTester.f70();

        }
    }
}
