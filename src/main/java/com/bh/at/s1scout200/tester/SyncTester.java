package com.bh.at.s1scout200.tester;

import org.junit.Assert;

public class SyncTester extends BaseTester{
    public void dynamicInitialization()
    {
        commonInitPage("S1Scout200.S1Scout200Page:uiJSON");
        lS1Scout200Page.syncSelection.init().collectData();
    }

    public void loadFile(String fileName)
    {
        dynamicInitialization();
        lS1Scout200Page.syncSelection.loadFile.click();
        lS1Scout200Page.loadFile.init().collectData();
        lS1Scout200Page.loadFile.browse.click();
        lS1Scout200Page.androidFileSelect.init().collectData();
        lS1Scout200Page.androidFileSelect.root.click();
        lS1Scout200Page.androidFileSelect.folders.init().collectData();

        for(int i=0;i<lS1Scout200Page.androidFileSelect.folders.size();i++)
        {
            if(lS1Scout200Page.androidFileSelect.folders.get(i).getText().contains("Downloads")) {
                lS1Scout200Page.androidFileSelect.folders.get(i).click();
                break;
            }
        }

        lS1Scout200Page.androidFileSelect.fileName.init().collectData();
        for(int j=0;j<lS1Scout200Page.androidFileSelect.fileName.size();j++)
        {
            if(lS1Scout200Page.androidFileSelect.fileName.get(j).getText().contains("CCRoute.xml")) {
                lS1Scout200Page.androidFileSelect.fileName.get(j).click();
                break;
            }
        }
        lS1Scout200Page.loadFile.init().collectData();
        lS1Scout200Page.loadFile.load.click();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        lS1Scout200Page.dialog.init().collectData();
        lS1Scout200Page.dialog.FileLoadSuccess.init().collectData();



    Assert.assertTrue(lS1Scout200Page.dialog.FileLoadSuccess.getText().contains("Load File Success"));
        lS1Scout200Page.dialog.fileOk.init().collectData();
        lS1Scout200Page.dialog.fileOk.click();




    }

}
