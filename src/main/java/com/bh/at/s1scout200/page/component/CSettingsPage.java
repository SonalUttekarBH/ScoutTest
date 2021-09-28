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

package com.bh.at.s1scout200.page.component;

import static com.bh.at.uiutils.UIUtilsFactory.uif;
import static com.bh.commonbaseutils.CommonBaseFactory.cbf;

import com.bh.at.iuiutils.IConfig;
import com.bh.at.iuiutils.IText;
import com.bh.at.s1scout200.tester.UiHelper;
import com.bh.at.uiutils.CElement;
import com.bh.icommonbaseutils.IJSONO;

public class CSettingsPage extends CElement {
  private static final IJSONO dataCollectorSimulatorConfig = cbf.getJSONOFromString("{\"loc\":[\"xpath\",\"//*[@test-tag='settings_simulator_navbar']\",\"webview\"],\"name\":\"dataCollectorSimulator\"}");

  private static final IJSONO measuringUnitsConfig = cbf.getJSONOFromString("{\"loc\":[\"xpath\",\"//*[@test-tag='settings_units_navbar']\",\"webview\"],\"name\":\"measuringUnits\"}");

  private static final IJSONO databaseOptionsConfig = cbf.getJSONOFromString("{\"loc\":[\"xpath\",\"//*[@test-tag='settings_databaseoptions_navbar']\",\"webview\"],\"name\":\"databaseOptions\"}");

  public IText dataCollectorSimulator;

  public IText measuringUnits;

  public IText databaseOptions;

  public CSettingsPage(IConfig config) {
    super(config);
  }

  @Override
  public CSettingsPage initComponents(int... optTimeoutInSecs) {
    super.initComponents(optTimeoutInSecs);
    dataCollectorSimulator.init(optTimeoutInSecs);
    measuringUnits.init(optTimeoutInSecs);
    databaseOptions.init(optTimeoutInSecs);

    return this;
  }

  @Override
  public CSettingsPage collectData() {
    if (elementExists()) {
      super.collectData();
      dataCollectorSimulator.collectData();
      measuringUnits.collectData();
      databaseOptions.collectData();
    }

    return this;
  }

  @Override
  protected CSettingsPage createComponents() {
    super.createComponents();
    dataCollectorSimulator = uif.getText(UiHelper.config.createConfig(dataCollectorSimulatorConfig, this));
    measuringUnits = uif.getText(UiHelper.config.createConfig(measuringUnitsConfig, this));
    databaseOptions = uif.getText(UiHelper.config.createConfig(databaseOptionsConfig, this));

    return this;
  }
}
