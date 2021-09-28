package com.bh.at.s1scout200.step;

import com.bh.at.s1scout200.tester.*;
import io.cucumber.java.en.And;

public class AutoRecordingSteps {
   // private static final AutoRecordingTester autoRecordingTester = TesterFactory.getTester("AutoRecording");

    private static final HomeTester homeTester=new HomeTester();
    private static final SettingTester settingTester=new SettingTester();
    private static final DevicesTester devicesTester=new DevicesTester();
    private static final MeasureTester measureTester=new MeasureTester();
    private static final SyncTester syncTester=new SyncTester();
    private static final RouteTester routeTester=new RouteTester();
    private static final BaseTester baseTester=new BaseTester();


    @And("user loads a {string} file")
    public void userLoadsAFile(String arg0) {

        homeTester.navigateToHomeOptions("Sync - Selection Mode");
        syncTester.loadFile(arg0);

    }

    public AutoRecordingSteps() {

    }

    @And("select a Route List")
    public void selectARouteList() {
        routeTester.selectRandomRoute();
    }

    @And("check if {string} in {string} {string}")
    public void checkIfInExists(String arg0, String arg1,String arg2) {
        routeTester.checkifVisible(arg0,arg1,arg2);

    }

    @And("check if we have {string} in {string}")
    public void checkIfWeHaveIn(String arg0, String arg1) {
    }

    @And("check if {string} tab {string}")
    public void checkIfTabExists(String arg0,String arg2) {
        routeTester.checkIfTabExists(arg0,arg2);

    }

    @And("Add a new sensor {string} in {string} {string}")
    public void addANewSensorIn(String arg0, String arg2,String arg3) {
        routeTester.addnewRouteSensor();
        measureTester.selectChannel(arg3);
        measureTester.navigateToAddSensor();
        System.out.println("LOG INFO-Select the {string} property");
        measureTester.navigateToProperty("name");
        measureTester.editNameSensor(arg0,arg2);
        measureTester.saveSensor();
        measureTester.selectChannelCheckbox(arg3);
    }

    @And("user starts measurement for {string} with delay {string}")
    public void userTakesMeasurement(String displayOpt,String delay) {
        if(displayOpt.equals("Guage"))
            routeTester.startMeasurementRouteGuage(delay);
        else
        routeTester.startMeasurementPlotRoute(delay);
        //baseTester.customWait(1000);
    }

    @And("user selects {string} in route Measurement")
    public void userSelectsInRouteMeasurement(String arg0) {
        routeTester.selectOptionMeasurement();

    }

    @And("user updates the delay to {string}")
    public void userUpdatesTheDelayTo(String arg0) {
        routeTester.addAutoDelayVal(Integer.parseInt(arg0));
    }

    @And("app starts new measurement and clicks on remeasure")
    public void MeasureAndClicksOnRemeasure() {
        routeTester.takeMeasurementAndRemeasurePlot();
    }

    @And("app starts new measurement and move to next")
    public void MeasureAndMoveToNext() {
        routeTester.startMeasurementAndMoveToNextPlot();
    }

    @And("app starts new measurement for Guage and clicks on Analyse")
    public void appStartsNewMeasurementAndClicksOnAnalyse() {
        System.out.println(" LOG INFO-Step implemented in 'user starts measurement for {} with delay {}'\n Step Kept for Documentation Purpose");
       // routeTester.measureAndAnalyseGuage();
    }

    @And("app starts new measurement for Guage and clicks on remeasure")
    public void appStartsNewMeasurementAndClicksOnRemeasureGuage() {
        System.out.println("LOG INFO-Step implemented in 'user starts measurement for {} with delay {}'\n Step Kept for Documentation Purpose");
        // routeTester.measureAndAnalyseGuage();
    }

    @And("user selects {string} in recording Mode")
    public void userSelectsInRecordingMode(String arg0) {
        routeTester.userSelectsOptnRecordingMode(arg0);
    }
}
