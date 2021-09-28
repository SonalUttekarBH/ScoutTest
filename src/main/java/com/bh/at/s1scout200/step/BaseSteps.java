/****************************************************************************************************************
 * BH Confidential                                                                                              *
 * Unpublished Copyright 2021.  Baker Hughes Company                                                            *
 *                                                                                                              *
 * NOTICE:  All information contained herein is, and remains the property of  Baker Hughes Company,  and/or its *
 * affiliates. The intellectual and technical concepts contained herein are proprietary to Baker Hughes Company *
 * and/or its affiliates and may be covered by  patents,  copyrights,  and/or trade secrets.   Dissemination of *
 * this information or reproduction of this material is  strictly forbidden unless prior  written permission is *
 * obtained from Baker Hughes Company.                                                                          *
 ***************************************************************************************************************/

   /* ** AUTOGENERATED - DO NOT MODIFY, ANY MODIFICATIONS WILL BE OVERWRITTEN!!!!! ** */

package com.bh.at.s1scout200.step;

import com.bh.at.s1scout200.tester.*;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BaseSteps {
  private BaseTester baseTester = null;
  private static final HomeTester homeTester=new HomeTester();
  private static final SettingTester settingTester=new SettingTester();
  private static final DevicesTester devicesTester=new DevicesTester();
  private static final MeasureTester measureTester=new MeasureTester();
  private static final SensorConfigTester sensorConfigTester=new SensorConfigTester();

  public BaseSteps() {
  }

  @Before
  public void setup(Scenario scenario) {
    if (null == baseTester) {
      String ff = scenario.getId().split("/")[1].split(":")[0].split("\\.")[1];
      baseTester = TesterFactory.getTester(ff);
    }
  }

  @Given("the app is launched")
  public void f57() {
    System.out.println("LOG INFO-the app is launched");
    baseTester.f57();
  }

  @When("user clicks {string} on license alert page {string}")
  public void commonInitPage(String p0, String uiFile) {

    System.out.println("LOG INFO-user clicks {string} on license alert page {string}");
    baseTester.commonInitPage(p0, uiFile);
  }

  @And("user clicks {string} on hazard alert page {string}")
  public void commonInitPage1(String p0, String uiFile) {
    System.out.println("LOG INFO-user clicks {string} on hazard alert page {string}");
    baseTester.commonInitPage1(p0, uiFile);
  }

  @And("user clicks {string} on device compatibility alert page {string}")
  public void commonInitPage2(String p0, String uiFile) {
    System.out.println("LOG INFO-user clicks {string} on device compatibility alert page {string}");
    baseTester.commonInitPage2(p0, uiFile);
  }

  @And("user navigates to homePage {string}")
  public void commonInitPage3(String uiFile) {
    System.out.println("LOG INFO-user navigates to homePage {string}");
    baseTester.commonInitPage3(uiFile);
  }

  @And("user enables Data Collector Simulator {string}")
  public void f62(String p0) {
    //baseTester.f62(p0);
//
    System.out.println("LOG INFO-user enables Data Collector Simulator {string}");
   homeTester.navigateToHomeOptions("Settings");
   settingTester.DataCollectorSimulatorEnable(p0);
  }

  @And("user enables simulator on devices")
  public void f63() {
    //baseTester.f63();
    System.out.println("LOG INFO-user enables simulator on devices");
    homeTester.navigateToHomeOptions("Devices");
    devicesTester.enableSimulator();
  }

  @And("user navigates to {string}")
  public void f64(String p0) {
    System.out.println("LOG INFO-user navigates to {string}");
    homeTester.navigateToHomeOptions(p0);
  }

  @And("Select any continuous data collection measurement {string}")
  public void f65(String p0) {
    //baseTester.f65(p0);
    System.out.println("LOG INFO-Select any continuous data collection measurement {string}");
    measureTester.selectDataCollectionMethod(p0);
  }

  @And("Add a new sensor {string}")
  public void f66(String arg0) {
   // baseTester.f66();
    System.out.println("LOG INFO-Add a new sensor {string}");
    measureTester.selectConfiguration("sensor");
    //measureTester.changeSensor(arg0);
    measureTester.selectChannel(arg0);
    measureTester.navigateToAddSensor();
  }

  @And("Select the {string} property")
  public void f67(String p0) {
   // baseTester.f67(p0);
    System.out.println("LOG INFO-Select the {string} property");
    measureTester.navigateToProperty(p0);
  }

  @And("Input a name for the sensor and then commit the changes {string} and {string}")
  public void f68(String p0,String parameterSet) {
   // baseTester.f68(p0);
    System.out.println("LOG INFO-Input a name for the sensor and then commit the changes {string} and {string}");
    measureTester.editNameSensor(p0,parameterSet);
  }

  @And("Save the sensor configuration {string}")
  public void f69(String p0) {
    //baseTester.f69(p0);
    System.out.println("LOG INFO-Save the sensor configuration {string}");
    measureTester.saveSensor();
    measureTester.selectChannelCheckbox(p0);
  }

  @Then("user quits the app")
  public void f70() {
    System.out.println("LOG INFO-user quits the app");

    // homeTester.appBack();
    baseTester.f70();
  }

  @And("Deselect the selected Channel")
  public void deselectTheSelectedChannel() {
    System.out.println("LOG INFO-Deselect the selected Channel");
    measureTester.deselectChannel();

  }

  @And("Navigates back")
  public void navigatesBack() {
    System.out.println("LOG INFO-Navigates back");

    homeTester.appBack();
  }

  @And("user resets the database")
  public void userResetsTheDatabase() {
    System.out.println("LOG INFO-user resets the database");

    homeTester.navigateToHomeOptions("Settings");
    settingTester.resetDb();
    homeTester.appBack();
    homeTester.appBack();
  }

  @And("Delete the sensor {string}")
  public void deleteTheSensor(String arg0) {
    System.out.println("LOG INFO-Delete the sensor {string}");
    measureTester.editSensor(arg0);
    // measureTester.editNameSensor("DemoSensor");
    measureTester.deleteSensor();
  }


  @And("user navigates to Routes")
  public void userNavigatesToRoutes() {
    homeTester.navigateToHomeOptions("Routes");
  }
}
