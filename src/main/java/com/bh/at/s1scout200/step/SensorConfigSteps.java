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
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import java.util.List;

public class SensorConfigSteps {
  private static final SensorConfigTester sensorConfigTester = TesterFactory.getTester("SensorConfig");

  private static final HomeTester homeTester=new HomeTester();
  private static final SettingTester settingTester=new SettingTester();
  private static final DevicesTester devicesTester=new DevicesTester();
  private static final MeasureTester measureTester=new MeasureTester();
  //private static final SensorConfigTester sensorConfigTester=new SensorConfigTester();

  public SensorConfigSteps() {
  }

  @And("Select any channel to setup the sensor configuration {string}")
  public void f10(String p0) {
    System.out.println("LOG INFO-Select any channel to setup the sensor configuration {string}");
    measureTester.commonInitPage("S1Scout200.S1Scout200Page:uiJSON");
    measureTester.selectConfiguration("sensor");
    //measureTester.changeSensor(arg0);
    measureTester.selectChannel(p0);
  }

  @And("Change the Voltage Range and Coupling to be of {string} Coupling type")
  public void f14(String p0) {
    //sensorConfigTester.f14(p0);
    System.out.println("LOG INFO-Change the Voltage Range and Coupling to be of {string} Coupling type");
    System.out.println("Helloooooooo" +p0);
    measureTester.navigateToProperty("VoltageRangeAndCoupling");
    measureTester.volRanCouplingSelection(p0);
  }

  @And("Modify the Zero DC Offset property {string}")
  public void f15(String arg0) {
    System.out.println("LOG INFO-Modify the Zero DC Offset property {string}");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    measureTester.navigateToProperty("Zero DC Offset");

    measureTester.editzeroDC(arg0);

  }

  @And("Change the sensor type to each of the available sensor settings")
  public void f16(DataTable dataTable) {
    System.out.println("LOG INFO-Change the sensor type to each of the available sensor settings");
    for(int i=0;i<dataTable.height();i++) {
      measureTester.navigateToProperty("type");
      System.out.println("Hello");
      System.out.println(dataTable.asLists().get(i).get(0));
      measureTester.modifyType(dataTable.asLists().get(i).get(0));
      measureTester.verifyUnits(dataTable.asLists().get(i).get(0));
      homeTester.commonInitPage("S1Scout200.S1Scout200Page:uiJSON");
      homeTester.appBack();
    }
  }

  @And("Modify the Units property {string}")
  public void f18(String arg0) {
    System.out.println("LOG INFO-Modify the Units property {string}");
    measureTester.navigateToProperty("units");
    measureTester.modifyUnits(arg0);
  }

  @And("Modify the Settling Time property {string}")
  public void f19(String arg0) {
    System.out.println("LOG INFO-Modify the Settling Time property {string}");
    measureTester.navigateToProperty("settlingtime");
    measureTester.modifySettlingTime(arg0);
  }

  @And("Modify the Auto Settling property {string}")
  public void f20(String arg0) {
    System.out.println("LOG INFO-Modify the Auto Settling property");
    measureTester.navigateToProperty("autosettling");
    measureTester.modifyAutoSettling(arg0);
  }

  @And("Modify the Sensitivity property {string}")
  public void f21(String arg0) {
    System.out.println("LOG INFO-Modify the Sensitivity property {string}");
    measureTester.navigateToProperty("sensitivity");
    measureTester.modifySensitivity("100");
  }

  @And("Modify the Drive Current property {string}")
  public void f22(String arg0) {
    System.out.println("LOG INFO-Modify the Drive Current property {string}");
    measureTester.navigateToProperty("driveCurrent");
    measureTester.modifyDriveCurrent(arg0);
  }

  @And("Navigate back to the channel selection screen")
  public void f24() {
    System.out.println("LOG INFO-Navigate back to the channel selection screen");
    homeTester.commonInitPage("S1Scout200.S1Scout200Page:uiJSON");
    homeTester.appBack();
  }



  @And("Edit the previously configured sensor {string}")
  public void f27(String p0) {

    System.out.println("LOG INFO-Edit the previously configured sensor {string}");
    measureTester.editSensor(p0);
  }

  @And("Modify all properties of the sensor to some other value within limits")
  public void f28() {
    System.out.println("LOG INFO-Modify all properties of the sensor to some other value within limits");
    measureTester.navigateToProperty("settlingtime");
    measureTester.modifySettlingTime("21");
    measureTester.navigateToProperty("autosettling");
    measureTester.modifyAutoSettling("Off");
    measureTester.navigateToProperty("type");
    measureTester.modifyType("Velocity");
  }

  @And("Delete the sensor")
  public void f32() {

    System.out.println("LOG INFO-Delete the sensor");
    sensorConfigTester.f32();
  }
}