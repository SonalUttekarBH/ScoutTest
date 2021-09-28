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

import com.bh.at.iuiutils.IButton;
import com.bh.at.iuiutils.IConfig;
import com.bh.at.s1scout200.tester.UiHelper;
import com.bh.at.uiutils.CElement;
import com.bh.icommonbaseutils.IJSONO;

public class CStatusBarPage extends CElement {
  private static final IJSONO backConfig = cbf.getJSONOFromString("{\"loc\":[\"xpath\",\"//*[@test-tag='statusbar_back_button']\",\"webview\"],\"name\":\"back\"}");

  private static final IJSONO titleConfig = cbf.getJSONOFromString("{\"loc\":[\"xpath\",\"//*[@test-tag='statusbar_pagetitle_name']\"],\"name\":\"title\"}");

  private static final IJSONO wifiConfig = cbf.getJSONOFromString("{\"loc\":[\"xpath\",\"//*[@test-tag='home_routes_button']\"],\"name\":\"wifi\"}");

  public IButton back;

  public IButton title;

  public IButton wifi;

  public CStatusBarPage(IConfig config) {
    super(config);
  }

  @Override
  public CStatusBarPage initComponents(int... optTimeoutInSecs) {
    super.initComponents(optTimeoutInSecs);
    back.init(optTimeoutInSecs);
    title.init(optTimeoutInSecs);

    return this;
  }

  @Override
  public CStatusBarPage collectData() {
    if (elementExists()) {
      super.collectData();
      back.collectData();
      title.collectData();
    }

    return this;
  }

  @Override
  protected CStatusBarPage createComponents() {
    super.createComponents();
    back = uif.getButton(UiHelper.config.createConfig(backConfig, this));
    title = uif.getButton(UiHelper.config.createConfig(titleConfig, this));
    wifi = uif.getButton(UiHelper.config.createConfig(wifiConfig, this));

    return this;
  }
}
