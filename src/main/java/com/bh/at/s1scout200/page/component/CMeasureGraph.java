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

public class CMeasureGraph extends CElement {
  private static final IJSONO pauseConfig = cbf.getJSONOFromString("{\"loc\":[\"xpath\",\"//*[@test-tag='measuringview_pause_button']\",\"webview\"],\"name\":\"pause\"}");

  private static final IJSONO ch1SpectrumUnitConfig = cbf.getJSONOFromString("{\"loc\":[\"xpath\",\"//*[starts-with(@id,'MEASURE_DISPLAY_') and contains(@id,'_SPECTRUM_1_legendId')]\",\"webview\"],\"name\":\"ch1SpectrumUnit\"}");

  private static final IJSONO ch1WaveformUnitConfig = cbf.getJSONOFromString("{\"loc\":[\"xpath\",\"//*[starts-with(@id,'MEASURE_DISPLAY_') and contains(@id,'WAVEFORM_1_legendId')]\",\"webview\"],\"name\":\"ch1WaveformUnit\"}");

  public IText pause;

  public IText ch1SpectrumUnit;

  public IText ch1WaveformUnit;

  public CMeasureGraph(IConfig config) {
    super(config);
  }

  @Override
  public CMeasureGraph initComponents(int... optTimeoutInSecs) {
    super.initComponents(optTimeoutInSecs);
    pause.init(optTimeoutInSecs);


    return this;
  }

  @Override
  public CMeasureGraph collectData() {
    if (elementExists()) {
      super.collectData();
      pause.collectData();

    }

    return this;
  }

  @Override
  protected CMeasureGraph createComponents() {
    super.createComponents();
    pause = uif.getText(UiHelper.config.createConfig(pauseConfig, this));
    ch1SpectrumUnit = uif.getText(UiHelper.config.createConfig(ch1SpectrumUnitConfig, this));
    ch1WaveformUnit = uif.getText(UiHelper.config.createConfig(ch1WaveformUnitConfig, this));

    return this;
  }
}