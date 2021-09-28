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

public class CSensorSettlingTime extends CElement {
  private static final IJSONO settlingTimeConfig = cbf.getJSONOFromString("{\"loc\":[\"xpath\",\"//*[@id='sensor.SettlingTime']\",\"webview\"],\"name\":\"settlingTime\"}");

  private static final IJSONO doneConfig = cbf.getJSONOFromString("{\"loc\":[\"xpath\",\"//*[@test-tag='message_done_button']\"],\"name\":\"done\"}");

  public IText settlingTime;

  public IText done;

  public CSensorSettlingTime(IConfig config) {
    super(config);
  }

  @Override
  public CSensorSettlingTime initComponents(int... optTimeoutInSecs) {
    super.initComponents(optTimeoutInSecs);
    settlingTime.init(optTimeoutInSecs);
    done.init(optTimeoutInSecs);

    return this;
  }

  @Override
  public CSensorSettlingTime collectData() {
    if (elementExists()) {
      super.collectData();
      settlingTime.collectData();
      done.collectData();
    }

    return this;
  }

  @Override
  protected CSensorSettlingTime createComponents() {
    super.createComponents();
    settlingTime = uif.getText(UiHelper.config.createConfig(settlingTimeConfig, this));
    done = uif.getText(UiHelper.config.createConfig(doneConfig, this));

    return this;
  }
}
