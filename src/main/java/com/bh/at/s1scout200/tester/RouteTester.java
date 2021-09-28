package com.bh.at.s1scout200.tester;

import org.junit.Assert;

public class RouteTester extends BaseTester{
    public void dynamicInitialization()
    {
        commonInitPage("S1Scout200.S1Scout200Page:uiJSON");
        lS1Scout200Page.route.init().collectData();
    }
    public void selectRandomRoute()
    {
        dynamicInitialization();
        lS1Scout200Page.route.selectEnterprise.click();
        lS1Scout200Page.enterpriseLists.init().collectData();
        lS1Scout200Page.enterpriseLists.selectEnterprise.init().collectData();
        lS1Scout200Page.enterpriseLists.selectEnterprise.get(0).click();

        lS1Scout200Page.route.init().collectData();
        lS1Scout200Page.route.selectFolder.init().collectData();
        lS1Scout200Page.route.selectFolder.click();

        lS1Scout200Page.folderLists.init().collectData();
        lS1Scout200Page.folderLists.selectFolder.init().collectData();
        lS1Scout200Page.folderLists.selectFolder.get(0).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lS1Scout200Page.route.init().collectData();
        lS1Scout200Page.route.selectRoute.init().collectData();
        lS1Scout200Page.route.selectRoute.get(0).click();



    }

    public void checkifVisible(String arg0, String arg1,String arg2) {
        //dynamicInitialization();
        boolean val=false;
        if(arg2.equals("exists"))
            val=true;
        commonInitPage("S1Scout200.S1Scout200Page:uiJSON");
        lS1Scout200Page.routeConfigView.init().collectData();
        switch (arg1) {
            case "Display":
                lS1Scout200Page.routeConfigView.displayMode.init().collectData();
                switch (arg0){
                    case "Gauge":

                        //Assert.assertTrue(lS1Scout200Page.routeConfigView.displayMode.guageDisplay.isDisplayed());
                        Assert.assertEquals(val,lS1Scout200Page.routeConfigView.displayMode.guageDisplay.isDisplayed());
                        System.out.println("LOG INFO-Gauge Visible");
                        break;
                    case "Plot":
                       // Assert.assertTrue(lS1Scout200Page.routeConfigView.displayMode.plotDisplay.isDisplayed());
                        Assert.assertEquals(val,lS1Scout200Page.routeConfigView.displayMode.plotDisplay.isDisplayed());
                        System.out.println("LOG INFO-Plot Visible");
                        break;
                }
                break;
            case "Recording Mode":
                lS1Scout200Page.routeConfigView.recordingMode.init().collectData();
                switch (arg0){
                    case "Quick":
                        //Assert.assertTrue(lS1Scout200Page.routeConfigView.recordingMode.quickRecording.isDisplayed());
                        Assert.assertEquals(val,lS1Scout200Page.routeConfigView.recordingMode.quickRecording.isDisplayed());
                        System.out.println("LOG INFO-Quick Visible");
                        break;
                    case "Auto":
                        //Assert.assertTrue(lS1Scout200Page.routeConfigView.recordingMode.autoRecording.isDisplayed());
                        Assert.assertEquals(val,lS1Scout200Page.routeConfigView.recordingMode.autoRecording.isDisplayed());
                        System.out.println("LOG INFO-Quick Visible");
                        break;
                    case "Manual":
                        //Assert.assertTrue(lS1Scout200Page.routeConfigView.recordingMode.manualRecording.isDisplayed());
                        Assert.assertEquals(val,lS1Scout200Page.routeConfigView.recordingMode.manualRecording.isDisplayed());
                        System.out.println("LOG INFO-Manual Visible");
                        break;
                }
                break;
        }


    }

    public void checkIfTabExists(String arg0,String arg2) {
        boolean val=false;
        if(arg2.equals("exists"))
            val=true;
        lS1Scout200Page.routeConfigView.init().collectData();
        switch (arg0){
            case "Alarm":
                Assert.assertTrue(lS1Scout200Page.routeConfigView.alarms.isDisplayed());
                Assert.assertEquals(val,lS1Scout200Page.routeConfigView.recordingMode.manualRecording.isDisplayed());
                System.out.println("LOG INFO-Alarm Visible");
                break;

            case "Sensors":
                Assert.assertTrue(lS1Scout200Page.routeConfigView.sensors.isDisplayed());
                Assert.assertEquals(val,lS1Scout200Page.routeConfigView.recordingMode.manualRecording.isDisplayed());
                System.out.println("LOG INFO-Sensors Visible");
                break;

            case "MultiChannel":
                lS1Scout200Page.routeConfigView.multiChannel.init().collectData();
                //Assert.assertTrue(lS1Scout200Page.routeConfigView.multiChannel.isDisplayed());
                Assert.assertEquals(val,lS1Scout200Page.routeConfigView.multiChannel.isDisplayed());
                System.out.println("LOG INFO-MultiChannel Visible");
                break;

            case "Delay":
                lS1Scout200Page.routeConfigView.recordingMode.delayF.init().collectData();
                Assert.assertEquals(val,lS1Scout200Page.routeConfigView.recordingMode.delayF.isDisplayed());
                System.out.println("LOG INFO-Delay Field "+lS1Scout200Page.routeConfigView.recordingMode.delayF.isDisplayed());
        }
    }

    public void addnewRouteSensor() {
        lS1Scout200Page.routeConfigView.init().collectData();
        lS1Scout200Page.routeConfigView.sensors.click();

    }

    public void startMeasurementRouteGuage(String delay) {

        int delayT=Integer.parseInt(delay);
        delayT=delayT*1000;
        lS1Scout200Page.routeConfigView.startBtn.click();

        lS1Scout200Page.routeMeasurement.init().collectData();
        String[] splitpath;
        int noOfPoint=0;
        System.out.println("No Of Machines" + lS1Scout200Page.routeMeasurement.machineView.size());


        int noOfAxis=lS1Scout200Page.routeMeasurement.machineView.get(0).machinePoints.size();
        int doneAxis=0;
        for (int i = 0; i < lS1Scout200Page.routeMeasurement.machineView.size(); i++) {
            //System.out.println("Machine name"+lS1Scout200Page.routeMeasurement.machineView.get(i).getText());
            String machinename=((lS1Scout200Page.routeMeasurement.machineView.get(i).getText()).split("\n"))[0];
            int pointFound=0;
            for (int j = doneAxis; j < lS1Scout200Page.routeMeasurement.machineView.get(i).machinePoints.size(); j++) {

                //System.out.println("Machine Axis"+lS1Scout200Page.routeMeasurement.machineView.get(i).machinePoints.get(j).getMAttribute("test-tag"));
                if((lS1Scout200Page.routeMeasurement.machineView.get(i).machinePoints.get(j).getMAttribute("test-tag")).contains(machinename))
                {
                    //System.out.println("Containcsw");
                    doneAxis++;
                    pointFound++;
                }
                else {
                    if(pointFound==0)
                  // System.out.println("");
                        continue;
                    else
                        break;

                }

            }
            //System.out.println("axis Found");
            if(pointFound>1)
            {
                lS1Scout200Page.routeMeasurement.machineView.get(i).click();
                break;

            }
                 }

        int noOfInCompPoints=lS1Scout200Page.routeMeasurement.pointsInComp.init().collectData().size();
        System.out.println("Total No of Points before Measurements"+noOfInCompPoints);


        lS1Scout200Page.routeMeasurement.measure.click();

        lS1Scout200Page.dialog.init().collectData();
        if (lS1Scout200Page.dialog.isDisplayed()) {
            lS1Scout200Page.dialog.okButton.init().collectData();
            lS1Scout200Page.dialog.okButton.click();
        }


        lS1Scout200Page.routeDialog.init().collectData();
        boolean flag=false;
        while (lS1Scout200Page.routeDialog.next.init().collectData().isDisplayed()) {
          flag=true;
          break;
        }
        System.out.println("1st Measurement");
        customWait(delayT);

        System.out.println("No of Points after 1st Measurement"+lS1Scout200Page.routeMeasurement.pointsInComp.init().collectData().size());
        Assert.assertTrue(lS1Scout200Page.routeMeasurement.pointsInComp.init().collectData().size()<noOfInCompPoints);
        noOfInCompPoints=lS1Scout200Page.routeMeasurement.pointsInComp.init().collectData().size();

        measureAndAnalyseGuage();

        customWait(2000);

        lS1Scout200Page.routeMeasurement.init().collectData();

        System.out.println("No of Points after starting measurement and clicking on Analyse"+lS1Scout200Page.routeMeasurement.pointsInComp.init().collectData().size());
        Assert.assertTrue(lS1Scout200Page.routeMeasurement.pointsInComp.init().collectData().size()==noOfInCompPoints);

        measureAndReameasureGuage();

        flag=false;
        lS1Scout200Page.routeDialog.init().collectData();
        while (lS1Scout200Page.routeDialog.next.init().collectData().isDisplayed()) {
            flag=true;
            break;
        }

            System.out.println("3rd Measurement");
        customWait(delayT);

        lS1Scout200Page.routeMeasurement.init().collectData();
        System.out.println("No Of Points after Remeasure Measurement"+lS1Scout200Page.routeMeasurement.pointsInComp.init().collectData().size());
        Assert.assertTrue(lS1Scout200Page.routeMeasurement.pointsInComp.init().collectData().size()<noOfInCompPoints);




    }

    public void measureAndReameasureGuage()
    {
        lS1Scout200Page.routeMeasurement.measure.click();


        boolean flag=false;
        lS1Scout200Page.routeDialog.init().collectData();
        while (lS1Scout200Page.routeDialog.next.init().collectData().isDisplayed()) {
            flag=true;
            break;
        }

        //System.out.println("2nd Measurement");
        customWait(1000);

        lS1Scout200Page.routeDialog.analyse.init().collectData().click();

        //lS1Scout200Page.routeMeasurement.init().collectData();
        lS1Scout200Page.routegraph.init().collectData();
        lS1Scout200Page.routegraph.remeasure.click();

    }

    public void measureAndAnalyseGuage()
    {
        boolean flag=false;
        lS1Scout200Page.routeDialog.init().collectData();
        while (lS1Scout200Page.routeDialog.next.init().collectData().isDisplayed()) {
            flag=true;
            break;
        }

        //System.out.println("2nd Measurement");
        customWait(1000);

        lS1Scout200Page.routeDialog.analyse.init().collectData().click();
        lS1Scout200Page.statusbar.init().collectData();
        lS1Scout200Page.statusbar.back.click();


    }

    public void selectOptionMeasurement() {
       // lS1Scout200Page.routeMeasurement.init().collectData();
        lS1Scout200Page.routeConfigView.init().collectData();
        lS1Scout200Page.routeConfigView.displayMode.plotDisplay.init().collectData().click();
    }

    public void addAutoDelayVal(int n)
    {
        n=n-3;
        lS1Scout200Page.routeConfigView.init().collectData();
        lS1Scout200Page.routeConfigView.recordingMode.init().collectData();
        lS1Scout200Page.routeConfigView.recordingMode.incrementVal.init().collectData();
        for (int i = 0; i < n; i++)
            lS1Scout200Page.routeConfigView.recordingMode.incrementVal.click();
    }

    public void startMeasurementPlotRoute(String delay) {


        int delayT=Integer.parseInt(delay);
        delayT=delayT*1000;


        lS1Scout200Page.routeConfigView.startBtn.click();

        lS1Scout200Page.routeMeasurement.init().collectData();
        String[] splitpath;
        int noOfPoint=0;
        //System.out.println("No Of Machines" + lS1Scout200Page.routeMeasurement.machineView.size());


        int noOfAxis=lS1Scout200Page.routeMeasurement.machineView.get(0).machinePoints.size();
        int doneAxis=0;
        for (int i = 0; i < lS1Scout200Page.routeMeasurement.machineView.size(); i++) {
            //System.out.println("Machine name"+lS1Scout200Page.routeMeasurement.machineView.get(i).getText());
            String machinename=((lS1Scout200Page.routeMeasurement.machineView.get(i).getText()).split("\n"))[0];
            int pointFound=0;
            for (int j = doneAxis; j < lS1Scout200Page.routeMeasurement.machineView.get(i).machinePoints.size(); j++) {

               // System.out.println("Machine Axis"+lS1Scout200Page.routeMeasurement.machineView.get(i).machinePoints.get(j).getMAttribute("test-tag"));
                if((lS1Scout200Page.routeMeasurement.machineView.get(i).machinePoints.get(j).getMAttribute("test-tag")).contains(machinename))
                {
                   // System.out.println("Containcsw");
                    doneAxis++;
                    pointFound++;
                }
                else {
                    if(pointFound==0)
                       // System.out.println("Not Containcsw");
                        continue;
                    else
                        break;

                }

            }
            //System.out.println("axis Found");
            if(pointFound>3)
            {
                lS1Scout200Page.routeMeasurement.machineView.get(i).click();
                break;

            }
        }

        // if(lS1Scout200Page.routeMeasurement.pointsComp.get())
        int noOfInCompPoints=lS1Scout200Page.routeMeasurement.pointsInComp.init().collectData().size();
        System.out.println("No of Points before measurements"+noOfInCompPoints);


        lS1Scout200Page.routeMeasurement.measure.click();

        lS1Scout200Page.dialog.init().collectData();
        if (lS1Scout200Page.dialog.isDisplayed()) {
            lS1Scout200Page.dialog.okButton.init().collectData();
            lS1Scout200Page.dialog.okButton.click();
        }


        customWait(2000);

        lS1Scout200Page.routegraph.init().collectData();
        boolean flag=false;
        while (lS1Scout200Page.routegraph.next.init().collectData().isDisplayed()) {
            flag=true;
            break;
        }
        //System.out.println("1st Measurement");

        customWait(delayT);


       customWait(1000);

        takeMeasurementAndRemeasurePlot();

        startMeasurementAndMoveToNextPlot();



    }

    public void startMeasurementAndMoveToNextPlot()
    {
        boolean flag=false;
        lS1Scout200Page.routegraph.init().collectData();
        while (lS1Scout200Page.routegraph.next.init().collectData().isDisplayed()) {
            flag=true;
            break;
        }

        System.out.println("3rd Measurement");


        lS1Scout200Page.routegraph.init().collectData();
        lS1Scout200Page.routegraph.next.click();

        customWait(2000);

    }
    public void takeMeasurementAndRemeasurePlot()
    {

        boolean flag=false;
        lS1Scout200Page.routegraph.init().collectData();
        while (lS1Scout200Page.routegraph.next.init().collectData().isDisplayed()) {
            flag=true;
            break;
        }
       // System.out.println("2nd Measurement");

        customWait(1000);

        lS1Scout200Page.routegraph.remeasure.init().collectData().click();

        customWait(1000);
        customWait(1000);
    }

    public void userSelectsOptnRecordingMode(String option)
    {
        lS1Scout200Page.routeConfigView.init().collectData();
        switch (option)
        {
            case "Auto":
                lS1Scout200Page.routeConfigView.recordingMode.autoRecording.click();
                break;
            case "Manual":
                lS1Scout200Page.routeConfigView.recordingMode.manualRecording.click();
                break;
            case "Quick":
                lS1Scout200Page.routeConfigView.recordingMode.quickRecording.click();
                break;
            default:
                System.out.println("Not Correct Option");
        }
    }

}
