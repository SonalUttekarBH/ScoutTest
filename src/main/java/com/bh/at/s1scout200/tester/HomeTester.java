package com.bh.at.s1scout200.tester;

import org.junit.Assert;

public class HomeTester extends BaseTester{
    public void dynamicInitialization()
    {
        commonInitPage("S1Scout200.S1Scout200Page:uiJSON");
        lS1Scout200Page.home.init().collectData();
    }

    public void navigateToHomeOptions(String option)
    {
        dynamicInitialization();
        switch (option) {

            case "Routes":
                lS1Scout200Page.home.routes.click();
                break;

            case "Measure":
                lS1Scout200Page.home.measure.click();
                break;
            case "Sync - Selection Mode":
                lS1Scout200Page.home.sync.click();
                break;

            case "Record Review":
                lS1Scout200Page.home.recordReview.click();
                break;

            case "Balancing":
                lS1Scout200Page.home.balancing.click();
                break;

            case "Devices":
                lS1Scout200Page.home.devices.click();
                break;

            case "Settings":
                lS1Scout200Page.home.settings.click();
                break;


            default:
                //System.out.printf("\n===========> Unhandled page file %s\n", uiFile);
                System.exit(1);
                break;


        }
        System.out.println("LOGINFO- Navigated to"+option);
        lS1Scout200Page.statusbar.init().collectData();
        String title=lS1Scout200Page.statusbar.title.getText();
        Assert.assertEquals(title,option);
    }

    public void appBack()
    {
        //dynamicInitialization();
        System.out.println("Reached inside appBack");
        lS1Scout200Page.statusbar.init().collectData();
        lS1Scout200Page.statusbar.back.click();
    }

    public void mobileBack()
    {
        System.out.println("Reached inside appBack");
        lS1Scout200Page.navigateBack();
    }
}
