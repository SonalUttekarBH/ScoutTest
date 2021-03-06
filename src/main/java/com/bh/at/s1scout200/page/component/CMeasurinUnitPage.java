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

public class CMeasurinUnitPage extends CElement {
  private static final IJSONO measuringUnitConfig = cbf.getJSONOFromString("{\"loc\":[\"xpath\",\"//*[@test-tag='settingsunitpreferences_unitset_rightcontent']\",\"webview\"],\"name\":\"measuringUnit\"}");

  public IText measuringUnit;

  public CMeasurinUnitPage(IConfig config) {
    super(config);
  }

  @Override
  public CMeasurinUnitPage initComponents(int... optTimeoutInSecs) {
    super.initComponents(optTimeoutInSecs);
    measuringUnit.init(optTimeoutInSecs);

    return this;
  }

  @Override
  public CMeasurinUnitPage collectData() {
    if (elementExists()) {
      super.collectData();
      measuringUnit.collectData();
    }

    return this;
  }

  @Override
  protected CMeasurinUnitPage createComponents() {
    super.createComponents();
    measuringUnit = uif.getText(UiHelper.config.createConfig(measuringUnitConfig, this));

    return this;
  }
}
