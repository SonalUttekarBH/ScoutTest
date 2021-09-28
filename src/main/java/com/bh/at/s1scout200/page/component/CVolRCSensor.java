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

import static com.bh.commonbaseutils.CommonBaseFactory.cbf;

import com.bh.at.iuiutils.IConfig;
import com.bh.at.iuiutils.IText;
import com.bh.at.s1scout200.tester.UiHelper;
import com.bh.at.uiutils.CElement;
import com.bh.at.uiutils.CElements;
import com.bh.at.uiutils.CText;
import com.bh.icommonbaseutils.IJSONO;

public class CVolRCSensor extends CElement {
  private static final IJSONO volRCConfig = cbf.getJSONOFromString("{\"loc\":[\"xpath\",\"//*[contains(@test-tag,'sensorchannelinput_')]\",\"webview\"],\"name\":\"volRC\"}");

  public CElements<IText> volRC;

  public CVolRCSensor(IConfig config) {
    super(config);
  }

  @Override
  public CVolRCSensor initComponents(int... optTimeoutInSecs) {
    super.initComponents(optTimeoutInSecs);
    volRC.init(optTimeoutInSecs);

    return this;
  }

  @Override
  public CVolRCSensor collectData() {
    if (elementExists()) {
      super.collectData();
      volRC.collectData();
    }

    return this;
  }

  @Override
  protected CVolRCSensor createComponents() {
    super.createComponents();
    volRC = new CElements<>(CText::new, UiHelper.config.createConfig(volRCConfig, this));

    return this;
  }
}