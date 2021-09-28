package com.bh.at.s1scout200.tester;

public class SettingTester extends BaseTester{

    public void dynamicInitialization()
    {
        commonInitPage("S1Scout200.S1Scout200Page:uiJSON");
        lS1Scout200Page.setting.init().collectData();
    }

    public void DataCollectorSimulatorEnable(String val)
    {
        dynamicInitialization();
        System.out.println("Hello Simulator"+lS1Scout200Page.setting.dataCollectorSimulator.getText());
        if(!lS1Scout200Page.setting.dataCollectorSimulator.getText().contains(val)) {
            System.out.println("LOGINFO-DataCollector needs to be changed");
            lS1Scout200Page.setting.dataCollectorSimulator.click();
            lS1Scout200Page.simulator.init().collectData();
            lS1Scout200Page.simulator.dataCollectorSimulatorCBox.click();

            String valC = lS1Scout200Page.simulator.dataCollectorSimulatorCBox.getAttribute("aria-checked");
            //Assert.assertTrue(valC==val);
            System.out.println("LogInfo:" + valC);
            System.out.println("LogInfo: Data Simulator Enabled from Settings");
            //boolean e=val.equals(valC);
            //System.out.println(e);
            // System.out.println(valC==val);
            //  Assert.assertTrue(valC==val);
            lS1Scout200Page.statusbar.init().collectData();
            lS1Scout200Page.statusbar.back.click();
            lS1Scout200Page.statusbar.back.click();
        }
        else
        {
            System.out.println("LOGINFO-DataCollector already as per requirement");
            lS1Scout200Page.statusbar.init().collectData();
            lS1Scout200Page.statusbar.back.click();
        }
    }

    public void navigateToSettingOptions(String arg0)
    {
        dynamicInitialization();
        if(arg0.equals("Unit Set"))
        {
            lS1Scout200Page.setting.measuringUnits.click();
        }
    }

    public void selectMeasureUnits(String arg0)
    {
        lS1Scout200Page.unitsView.init().collectData();
        lS1Scout200Page.unitsView.measuringUnit.click();

        lS1Scout200Page.units.init().collectData();
        if(arg0.contains("S.I"))
        lS1Scout200Page.units.sIunit.click();
        else if(arg0.contains("U.S"))
            lS1Scout200Page.units.uSunit.click();
//        for(int i=0;i<lS1Scout200Page.storeunit.storeunitVal.size();i++) {
//            if((lS1Scout200Page.storeunit.storeunitVal.get(i).getText()).contains(arg0))
//                lS1Scout200Page.storeunit.storeunitVal.get(i).click();
//            System.out.println("out out ");
//            break;
//        }


    }
    public void resetDb()
    {
        dynamicInitialization();
        lS1Scout200Page.setting.databaseOptions.click();
        lS1Scout200Page.dboptn.init().click();
        lS1Scout200Page.dboptn.dbOptionPage.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lS1Scout200Page.dialog.init().collectData();
        lS1Scout200Page.dialog.okButton.init().collectData();
        lS1Scout200Page.dialog.okButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lS1Scout200Page.dialog.init().collectData();
        lS1Scout200Page.dialog.okButton.init().collectData();
        lS1Scout200Page.dialog.okButton.click();

    }

}
