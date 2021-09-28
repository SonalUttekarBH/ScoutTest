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

public class CTypeParamset extends CElement {
    private static final IJSONO paramsetTypeConfig = cbf.getJSONOFromString("{\"loc\":[\"xpath\",\"//*[contains(@test-tag,'_listitem')]\",\"webview\"],\"name\":\"pause\"}");


    public CElements<IText> paramsetType;



    public CTypeParamset(IConfig config) {
        super(config);
    }

    @Override
    public CTypeParamset initComponents(int... optTimeoutInSecs) {
        super.initComponents(optTimeoutInSecs);
        // pause.init(optTimeoutInSecs);
        paramsetType.init(optTimeoutInSecs);
        //ch1WaveformUnit.init(optTimeoutInSecs);

        return this;
    }

    @Override
    public CTypeParamset collectData() {
        if (elementExists()) {
            super.collectData();
            paramsetType.collectData();

        }

        return this;
    }

    @Override
    protected CTypeParamset createComponents() {
        super.createComponents();
        //paramsetType = uif.getText(UiHelper.config.createConfig(paramsetTypeConfig, this));
        paramsetType = new CElements<>(CText::new, UiHelper.config.createConfig(paramsetTypeConfig, this));

        return this;
    }
}
