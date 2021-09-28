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
import com.bh.at.uiutils.CElements;
import com.bh.at.uiutils.CText;
import com.bh.icommonbaseutils.IJSONO;

public class CFileSelect extends CElement {
  private static final IJSONO fileNameConfig = cbf.getJSONOFromString("{\"loc\":[\"xpath\",\"//*[@resource-id='android:id/title']\",\"native\"],\"name\":\"fileName\"}");

  private static final IJSONO rootConfig = cbf.getJSONOFromString("{\"loc\":[\"xpath\",\"//*[@content-desc='Show roots']\",\"native\"],\"name\":\"root\"}");

  private static final IJSONO foldersConfig = cbf.getJSONOFromString("{\"loc\":[\"xpath\",\"//*[@resource-id='android:id/title']\",\"native\"],\"name\":\"folders\"}");

  public CElements<IText> fileName;

  public IText root;

  public CElements<IText> folders;

  public CFileSelect(IConfig config) {
    super(config);
  }

  @Override
  public CFileSelect initComponents(int... optTimeoutInSecs) {
    super.initComponents(optTimeoutInSecs);
    root.init(optTimeoutInSecs);

    return this;
  }

  @Override
  public CFileSelect collectData() {
    if (elementExists()) {
      super.collectData();
      root.collectData();
    }

    return this;
  }

  @Override
  protected CFileSelect createComponents() {
    super.createComponents();
    fileName = new CElements<>(CText::new, UiHelper.config.createConfig(fileNameConfig, this));
    root = uif.getText(UiHelper.config.createConfig(rootConfig, this));
    folders = new CElements<>(CText::new, UiHelper.config.createConfig(foldersConfig, this));

    return this;
  }
}