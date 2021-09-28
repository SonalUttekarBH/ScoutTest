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

package com.bh.at.s1scout200.page;

import static com.bh.at.uiutils.UIUtilsFactory.uif;
import static com.bh.commonbaseutils.CommonBaseFactory.cbf;

import com.bh.at.iuiutils.IButton;
import com.bh.at.iuiutils.IText;
import com.bh.at.s1scout200.tester.UiHelper;
import com.bh.at.uiutils.CMobilePage;
import com.bh.icommonbaseutils.IJSONO;

public class LicenseAlertPage extends CMobilePage {
  private static final IJSONO titleConfig = cbf.getJSONOFromString("{\"loc\":[\"id\",\"android:id/alertTitle\"],\"name\":\"title\"}");

  private static final IJSONO messageConfig = cbf.getJSONOFromString("{\"loc\":[\"id\",\"android:id/message\"],\"name\":\"message\"}");

  private static final IJSONO viewConfig = cbf.getJSONOFromString("{\"loc\":[\"id\",\"com.bently.scout200:id/eulaview\"],\"name\":\"view\"}");

  private static final IJSONO rejectConfig = cbf.getJSONOFromString("{\"loc\":[\"id\",\"com.bently.scout200:id/eulareject\"],\"name\":\"reject\"}");

  private static final IJSONO acceptConfig = cbf.getJSONOFromString("{\"loc\":[\"id\",\"com.bently.scout200:id/eulaconfirm\"],\"name\":\"accept\"}");

  public IText title;

  public IText message;

  public IButton view;

  public IButton reject;

  public IButton accept;

  public LicenseAlertPage(IJSONO uiDriverCaps) {
    super(uiDriverCaps);
  }

  @Override
  public void quit() {
    super.quit();
  }

  @Override
  public LicenseAlertPage init(int... optTimeoutInSecs) {
    super.init(optTimeoutInSecs);

    return this;
  }

  @Override
  public LicenseAlertPage initComponents(int... optTimeoutInSecs) {
    super.initComponents(optTimeoutInSecs);
    title.init(optTimeoutInSecs);
    message.init(optTimeoutInSecs);
    view.init(optTimeoutInSecs);
    reject.init(optTimeoutInSecs);
    accept.init(optTimeoutInSecs);

    return this;
  }

  @Override
  public LicenseAlertPage collectData() {
    super.collectData();
    title.collectData();
    message.collectData();
    view.collectData();
    reject.collectData();
    accept.collectData();

    return this;
  }

  @Override
  protected LicenseAlertPage createComponents() {
    super.createComponents();
    title = uif.getText(UiHelper.config.createConfig(titleConfig, this));
    message = uif.getText(UiHelper.config.createConfig(messageConfig, this));
    view = uif.getButton(UiHelper.config.createConfig(viewConfig, this));
    reject = uif.getButton(UiHelper.config.createConfig(rejectConfig, this));
    accept = uif.getButton(UiHelper.config.createConfig(acceptConfig, this));

    return this;
  }
}