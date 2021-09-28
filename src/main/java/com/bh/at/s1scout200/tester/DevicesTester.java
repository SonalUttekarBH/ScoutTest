package com.bh.at.s1scout200.tester;

import org.junit.Assert;

public class DevicesTester extends BaseTester{

    public void dynamicInitialization()
    {
        commonInitPage("S1Scout200.S1Scout200Page:uiJSON");
        lS1Scout200Page.devices.init().collectData();
    }

    public void enableSimulator()
    {
        dynamicInitialization();
        System.out.println("Check attri");
        System.out.println(lS1Scout200Page.devices.simulatorCBox.getMAttribute("test-tag"));
        lS1Scout200Page.devices.simulatorCBox.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lS1Scout200Page.devices.done.click();

        lS1Scout200Page.dialog.init().collectData();
        lS1Scout200Page.dialog.dialogText.init().collectData();
        //System.out.println(lS1Scout200Page.dialog.dialogText.get);
        String message=lS1Scout200Page.dialog.dialogText.getText();
        System.out.println("Message Printed"+message);
        Assert.assertEquals("The app changes color for the Data Collector Simulator. Use the simulator for demonstration only.",message);
        //System.out.println(lS1Scout200Page.dialog.okButton.getStyle("background"));
        lS1Scout200Page.dialog.okButton.init().collectData();
        lS1Scout200Page.dialog.okButton.click();
        //lS1Scout200Page.devices.init().collectData();
        System.out.println("LOGIINFO-Devices simulator Enable");

    }
}
