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

public class CLoadFile extends CElement {
  private static final IJSONO browseConfig = cbf.getJSONOFromString("{\"loc\":[\"xpath\",\"//*[@test-tag='load_browse_test_navbar']\",\"webview\"],\"name\":\"browse\"}");

  private static final IJSONO loadConfig = cbf.getJSONOFromString("{\"loc\":[\"xpath\",\"//*[@test-tag='sync_load_button']\",\"webview\"],\"name\":\"load\"}");

  public IText browse;

  public IText load;

  public CLoadFile(IConfig config) {
    super(config);
  }

  @Override
  public CLoadFile initComponents(int... optTimeoutInSecs) {
    super.initComponents(optTimeoutInSecs);
    browse.init(optTimeoutInSecs);
    load.init(optTimeoutInSecs);

    return this;
  }

  @Override
  public CLoadFile collectData() {
    if (elementExists()) {
      super.collectData();
      browse.collectData();
      load.collectData();
    }

    return this;
  }

  @Override
  protected CLoadFile createComponents() {
    super.createComponents();
    browse = uif.getText(UiHelper.config.createConfig(browseConfig, this));
    load = uif.getText(UiHelper.config.createConfig(loadConfig, this));

    return this;
  }
}