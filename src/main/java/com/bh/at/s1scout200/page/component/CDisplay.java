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

public class CDisplay extends CElement {
  private static final IJSONO guageDisplayConfig = cbf.getJSONOFromString("{\"loc\":[\"xpath\",\"//*[@test-tag='routessavemode_preview_button']\",\"webview\"],\"name\":\"guageDisplay\"}");

  private static final IJSONO plotDisplayConfig = cbf.getJSONOFromString("{\"loc\":[\"xpath\",\"//*[@test-tag='routessavemode_auto_button']\",\"webview\"],\"name\":\"plotDisplay\"}");

  public IText guageDisplay;

  public IText plotDisplay;

  public CDisplay(IConfig config) {
    super(config);
  }

  @Override
  public CDisplay initComponents(int... optTimeoutInSecs) {
    super.initComponents(optTimeoutInSecs);
    guageDisplay.init(optTimeoutInSecs);
    plotDisplay.init(optTimeoutInSecs);

    return this;
  }

  @Override
  public CDisplay collectData() {
    if (elementExists()) {
      super.collectData();
      guageDisplay.collectData();
      plotDisplay.collectData();
    }

    return this;
  }

  @Override
  protected CDisplay createComponents() {
    super.createComponents();
    guageDisplay = uif.getText(UiHelper.config.createConfig(guageDisplayConfig, this));
    plotDisplay = uif.getText(UiHelper.config.createConfig(plotDisplayConfig, this));

    return this;
  }
}
