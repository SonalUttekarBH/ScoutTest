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

public class CSensorSelectionPage extends CElement {
  private static final IJSONO sensorListConfig = cbf.getJSONOFromString("{\"loc\":[\"xpath\",\"//*[contains(@test-tag,'_listitem')]\",\"webview\"],\"name\":\"sensorList\"}");

  private static final IJSONO addParamConfig = cbf.getJSONOFromString("{\"loc\":[\"xpath\",\"//*[@test-tag='sensorselection_add_button']\"],\"name\":\"addParam\"}");

  private static final IJSONO editParamConfig = cbf.getJSONOFromString("{\"loc\":[\"xpath\",\"//*[@test-tag='sensorselection_editmode_button']\"],\"name\":\"editParam\"}");

  private static final IJSONO selectionModeConfig = cbf.getJSONOFromString("{\"loc\":[\"xpath\",\"//*[@test-tag='sensorselection_selectionmode_button']\"],\"name\":\"selectionMode\"}");

  public CElements<IText> sensorList;

  public IText addParam;

  public IText editParam;

  public IText selectionMode;

  public CSensorSelectionPage(IConfig config) {
    super(config);
  }

  @Override
  public CSensorSelectionPage initComponents(int... optTimeoutInSecs) {
    super.initComponents(optTimeoutInSecs);
    sensorList.init(optTimeoutInSecs);
    addParam.init(optTimeoutInSecs);
    editParam.init(optTimeoutInSecs);

    return this;
  }

  @Override
  public CSensorSelectionPage collectData() {
    if (elementExists()) {
      super.collectData();
      sensorList.collectData();
      addParam.collectData();
      editParam.collectData();
    }

    return this;
  }

  @Override
  protected CSensorSelectionPage createComponents() {
    super.createComponents();
    sensorList = new CElements<>(CText::new, UiHelper.config.createConfig(sensorListConfig, this));
    addParam = uif.getText(UiHelper.config.createConfig(addParamConfig, this));
    editParam = uif.getText(UiHelper.config.createConfig(editParamConfig, this));
    selectionMode = uif.getText(UiHelper.config.createConfig(selectionModeConfig, this));

    return this;
  }
}
