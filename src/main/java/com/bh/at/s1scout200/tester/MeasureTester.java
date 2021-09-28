package com.bh.at.s1scout200.tester;

import com.bh.at.iuiutils.IText;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MeasureTester extends BaseTester{

    public void dynamicInitialization()
    {
        commonInitPage("S1Scout200.S1Scout200Page:uiJSON");
        lS1Scout200Page.measure.init().collectData();
    }

    public void selectDataCollectionMethod(String val)
    {
        dynamicInitialization();
        switch (val) {

            case "Spectrum / Waveform":
                lS1Scout200Page.measure.spectrumWfm.click();
                break;
            case "Demodulation":
                lS1Scout200Page.measure.demodulation.click();
                break;

            default:
                // System.out.printf("\n===========> Unhandled page file %s\n", uiFile);
                System.exit(1);
                break;

        }

        String val1="Measure Configuration "+val;
        System.out.println("LOGINFO- Navigated to val1"+val1);
        lS1Scout200Page.statusbar.init().collectData();
        String title=lS1Scout200Page.statusbar.title.getText();
        System.out.println("LOGINFO- Navigated to title"+title);
        Assert.assertEquals(title,val1);

    }

    public void addParamsetwithType(String arg0,String arg1)
    {
        commonInitPage("S1Scout200.S1Scout200Page:uiJSON");
        lS1Scout200Page.measureConfig.init().collectData();
        lS1Scout200Page.measureConfig.paramset.click();
        lS1Scout200Page.paramsetSelection.init().collectData();
        lS1Scout200Page.paramsetSelection.addParam.click();
        lS1Scout200Page.addEditParamset.init().collectData();
        lS1Scout200Page.addEditParamset.type.click();
        lS1Scout200Page.typeStoreunit.init().collectData();
        for(int i=0;i< lS1Scout200Page.typeStoreunit.paramsetType.size();i++) {
            if((lS1Scout200Page.typeStoreunit.paramsetType.get(i).getText()).equals("Spec+Wfm")) {
                lS1Scout200Page.typeStoreunit.paramsetType.get(i).click();
                break;
            }
        }
        if(arg1.equals("Spectrum / Waveform")) {
            lS1Scout200Page.addEditParamset.init().collectData();
            lS1Scout200Page.addEditParamset.storeUnit.click();
            lS1Scout200Page.storeunit.init().collectData();
            for (int i = 0; i < lS1Scout200Page.storeunit.storeunitVal.size(); i++) {
                if ((lS1Scout200Page.storeunit.storeunitVal.get(i).getText()).equals(arg0)) {
                    lS1Scout200Page.storeunit.storeunitVal.get(i).click();
                    break;
                }
            }
        }
        lS1Scout200Page.addEditParamset.init().collectData();
        lS1Scout200Page.addEditParamset.save.click();

    }

    public void navigateToAddSensor()
    {
        lS1Scout200Page.sensorSelection.init().collectData();
        lS1Scout200Page.sensorSelection.addParam.click();
    }

    public void selectConfiguration(String val)
    {
       // commonInitPage("S1Scout200.S1Scout200Page:uiJSON");
        lS1Scout200Page.measureConfig.init().collectData();
        switch (val) {

            case "sensor":
                lS1Scout200Page.measureConfig.sensors.click();
                break;

            default:
                // System.out.printf("\n===========> Unhandled page file %s\n", uiFile);
                System.exit(1);
                break;

        }


    }
    public void selectChannel(String channel)
    {
        IText ch=getSensor(channel);
        ch.click();
    }


    public IText getSensor(String channel)
    {
        commonInitPage("S1Scout200.S1Scout200Page:uiJSON");
        lS1Scout200Page.sensorSetup.init().collectData();
        IText channelObj=null;
        switch (channel) {

            case "CH1":
                channelObj = lS1Scout200Page.sensorSetup.ch1Name;
                break;

            case "CH2":
                channelObj=lS1Scout200Page.sensorSetup.ch2Name;
                break;

            case "CH3":
                channelObj=lS1Scout200Page.sensorSetup.ch3Name;
                break;

            case "CH4":
                channelObj=lS1Scout200Page.sensorSetup.ch4Name;
                break;

            default:
                // System.out.printf("\n===========> Unhandled page file %s\n", uiFile);
                System.exit(1);
                break;

        }
        return channelObj;
    }

    public void navigateToProperty(String prop)
    {
        commonInitPage("S1Scout200.S1Scout200Page:uiJSON");
        lS1Scout200Page.addEditSensor.init().collectData();
        if(prop.equals("name")) {

            lS1Scout200Page.addEditSensor.name.click();
        }
        else if(prop.equals("VoltageRangeAndCoupling"))
        {
            lS1Scout200Page.addEditSensor.volRangeCoupling.click();
        }
        else if(prop.equals("Zero DC Offset"))
        {
            lS1Scout200Page.addEditSensor.zeroDCOffset.init().collectData();
            lS1Scout200Page.addEditSensor.zeroDCOffset.click();
        }
        else if(prop.equals("type"))
        {
            lS1Scout200Page.addEditSensor.type.click();
        }
        else if(prop.equals("units"))
        {
            lS1Scout200Page.addEditSensor.unit.click();
        }
        else if(prop.equals("settlingtime"))
        {
            lS1Scout200Page.addEditSensor.settlingTime.click();
        }
        else if(prop.equals("autosettling"))
        {
            lS1Scout200Page.addEditSensor.autoSettling.click();
        }
        else if(prop.equals("sensitivity"))
        {
            lS1Scout200Page.addEditSensor.sensitivity.click();
        }
        else if(prop.equals("driveCurrent"))
        {
            lS1Scout200Page.addEditSensor.driveCurrent.click();
        }
        // lS1Scout200Page.nameSensor.sensorName.sendKeys()
    }

    public void editNameSensor(String val,String type)
    {
       String val1=val+type;
        //lS1Scout200Page.navigateBack();
        lS1Scout200Page.nameSensor.init().collectData();
        lS1Scout200Page.nameSensor.sensorName.clearText();
        lS1Scout200Page.nameSensor.sensorName.sendKeys(val1);
        lS1Scout200Page.nameSensor.done.click();
        lS1Scout200Page.addEditSensor.init().collectData();
        System.out.println(" Name Sensor Val"+lS1Scout200Page.addEditSensor.name.getText());
        Assert.assertEquals(val1,lS1Scout200Page.addEditSensor.name.getText());

    }

    public void modifyType(String val)
    {
        lS1Scout200Page.senType.init().collectData();
        int size=lS1Scout200Page.senType.type.size();
        for (int i=0;i<size;i++)
        {
            if((lS1Scout200Page.senType.type.get(i).getText()).equals(val))
            {
                lS1Scout200Page.senType.type.get(i).click();
                break;
            }
        }
        lS1Scout200Page.addEditSensor.init().collectData();
        Assert.assertEquals(val,lS1Scout200Page.addEditSensor.type.getText());
    }


    public void saveSensor()
    {
        lS1Scout200Page.addEditSensor.init().collectData();
        lS1Scout200Page.addEditSensor.save.click();
        //lS1Scout200Page.sensorSelection.init().collectData();
       // changeSensor(val);

    }

    public void selectChannelCheckbox(String arg0)
    {
        lS1Scout200Page.sensorSetup.init().collectData();
        if(arg0.equals("CH1"))
        lS1Scout200Page.sensorSetup.ch1Box.click();
        else if(arg0.equals("CH2"))
            lS1Scout200Page.sensorSetup.ch2Box.click();

        lS1Scout200Page.sensorSetup.done.click();
    }

    public void clickMeasure()
    {
        lS1Scout200Page.measureConfig.init().collectData();
        lS1Scout200Page.measureConfig.measure.click();
    }

    public void pauseMeasurement()
    {
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lS1Scout200Page.measureGraph.init().collectData();
        lS1Scout200Page.measureGraph.pause.click();
    }

    public void getUnitsFromGraph(String spectrumUnit, String waveformUnit)
    {
        lS1Scout200Page.measureGraph.init().collectData();
        lS1Scout200Page.measureGraph.ch1WaveformUnit.init().collectData();
        lS1Scout200Page.measureGraph.ch1SpectrumUnit.init().collectData();
        String specUnit=lS1Scout200Page.measureGraph.ch1SpectrumUnit.getText();
        String waveUnit=lS1Scout200Page.measureGraph.ch1WaveformUnit.getText();
        System.out.println(" Units on Graph"+ specUnit+"   "+waveUnit);
       // Assert.assertEquals(spectrumUnit,specUnit);
        //Assert.assertEquals(waveformUnit,waveUnit);
        Assert.assertTrue(specUnit.contains(spectrumUnit));
        Assert.assertTrue(waveUnit.contains(waveformUnit));
    }

    public void volRanCouplingSelection(String arg0) {
        lS1Scout200Page.volRCSensor.init().collectData();
        int size = lS1Scout200Page.volRCSensor.volRC.size();
        String val = "";
        System.out.println("size " + size);
        //System.out.println("size " + lS1Scout200Page.volRCSensor.volRC.get(1).getText());
        // String val;
        for (int j = 1; j < size; j++)
        {
            System.out.println(j);

            val=lS1Scout200Page.volRCSensor.volRC.get(j).getText();
            System.out.println("val "+val);
            System.out.println("arg "+arg0);
            System.out.println("boolean "+val.contains(arg0));
            if(val.contains(arg0))
            {
                lS1Scout200Page.volRCSensor.volRC.get(j).click();
                break;
            }

        }
        lS1Scout200Page.addEditSensor.init().collectData();
        if(arg0.contains("DC")) {

            System.out.println("zero dc visible" + lS1Scout200Page.addEditSensor.zeroDCOffset.init().collectData().isDisplayed());
            Assert.assertTrue(lS1Scout200Page.addEditSensor.zeroDCOffset.init().collectData().isDisplayed());
            Assert.assertFalse(lS1Scout200Page.addEditSensor.biasVolCheck.init().collectData().isDisplayed());
        }
        else {
            System.out.println("bias visible" + lS1Scout200Page.addEditSensor.biasVolCheck.init().collectData().isDisplayed());
            Assert.assertTrue(lS1Scout200Page.addEditSensor.biasVolCheck.init().collectData().isDisplayed());
            Assert.assertFalse(lS1Scout200Page.addEditSensor.zeroDCOffset.init().collectData().isDisplayed());
        }
        lS1Scout200Page.addEditSensor.init().collectData();
        Assert.assertTrue((lS1Scout200Page.addEditSensor.volRangeCoupling.getText()).contains(arg0));
    }

    public void deselectChannel()
    {
        selectConfiguration("sensor");
        lS1Scout200Page.sensorSetup.init().collectData();
        lS1Scout200Page.sensorSetup.ch1Box.click();
        lS1Scout200Page.sensorSetup.done.click();

    }

    public void editzeroDC(String arg0)
    {
        lS1Scout200Page.zeroDCOff.init().collectData();
        lS1Scout200Page.zeroDCOff.sensorName.clearText();
        lS1Scout200Page.zeroDCOff.sensorName.sendKeys(arg0);
//lS1Scout200Page.navigateBack();
        lS1Scout200Page.zeroDCOff.done.click();

        lS1Scout200Page.addEditSensor.init().collectData();
        String unit="";
        if((lS1Scout200Page.addEditSensor.unit.getText()).split("/").length==3)
            unit=((lS1Scout200Page.addEditSensor.unit.getText()).split("/"))[1]+((lS1Scout200Page.addEditSensor.unit.getText()).split("/"))[2];
        else
            unit=((lS1Scout200Page.addEditSensor.unit.getText()).split("/"))[1];
        lS1Scout200Page.addEditSensor.zeroDCOffset.init().collectData();
        Assert.assertEquals(lS1Scout200Page.addEditSensor.zeroDCOffset.getText(),arg0+unit);

///navigate back
    }

    public void modifyUnits(String val)
    {
        lS1Scout200Page.senUnit.init().collectData();
        System.out.println();
        for (int i=1;i<lS1Scout200Page.senUnit.unit.size();i++) {
            if(lS1Scout200Page.senUnit.unit.get(i).getText().equals(val)) {
                lS1Scout200Page.senUnit.unit.get(i).click();
                break;
            }
        }

        lS1Scout200Page.addEditSensor.init().collectData();
        System.out.println("LOG INFO-Units modified to "+lS1Scout200Page.addEditSensor.unit.getText());
        Assert.assertEquals(lS1Scout200Page.addEditSensor.unit.getText(),val);
    }

    public void modifySettlingTime(String val)
    {
        lS1Scout200Page.senSettlingTime.init().collectData();
        lS1Scout200Page.senSettlingTime.settlingTime.clearText();
        lS1Scout200Page.senSettlingTime.settlingTime.sendKeys(val);
        lS1Scout200Page.senSettlingTime.done.click();

        lS1Scout200Page.addEditSensor.init().collectData();
        System.out.println("LOG INFO-Settling time modified to "+lS1Scout200Page.addEditSensor.settlingTime.getText());
       Assert.assertEquals(lS1Scout200Page.addEditSensor.settlingTime.getText(),val+"s");
    }

    public void modifySensitivity(String val)
    {
        lS1Scout200Page.senSensitivity.init().collectData();
        lS1Scout200Page.senSensitivity.sensitivity.clearText();
        lS1Scout200Page.senSensitivity.sensitivity.sendKeys(val);
        lS1Scout200Page.senSensitivity.done.click();

        lS1Scout200Page.addEditSensor.init().collectData();
        System.out.println("LOG INFO-Sensitivity modified to "+lS1Scout200Page.addEditSensor.sensitivity.getText());
        Assert.assertEquals(lS1Scout200Page.addEditSensor.sensitivity.getText(),val);
    }

    public void modifyDriveCurrent(String val)
    {
        lS1Scout200Page.driveCurrentSensor.init().collectData();
        if(val.equals("On"))
            lS1Scout200Page.driveCurrentSensor.on.click();
        else
            lS1Scout200Page.driveCurrentSensor.off.click();
        lS1Scout200Page.addEditSensor.init().collectData();
        System.out.println("LOG INFO-Drive Current modified to "+lS1Scout200Page.addEditSensor.driveCurrent.getText());
        Assert.assertEquals(lS1Scout200Page.addEditSensor.driveCurrent.getText(),val);
    }

    public void editSensor(String val)
    {
        lS1Scout200Page.sensorSelection.init().collectData();
        lS1Scout200Page.sensorSelection.editParam.click();
        for(int i=0;i<lS1Scout200Page.sensorSelection.sensorList.size();i++) {
            System.out.println("edit sen"+lS1Scout200Page.sensorSelection.sensorList.get(i).getText());
            if ((lS1Scout200Page.sensorSelection.sensorList.get(i).getText()).contains(val)) {
                lS1Scout200Page.sensorSelection.sensorList.get(i).click();
                break;
            }

        }
    }

    public void modifyAutoSettling(String val)
    {
        lS1Scout200Page.autoSettling.init().collectData();
        for(int i=0;i<lS1Scout200Page.autoSettling.autosettling.size();i++) {
            System.out.println("Auto "+lS1Scout200Page.autoSettling.autosettling.get(i).getText());
            if((lS1Scout200Page.autoSettling.autosettling.get(i).getText()).equals(val))
            {
                lS1Scout200Page.autoSettling.autosettling.get(i).click();
                break;
            }
        }
    }

    public void deleteSensor()
    {
        lS1Scout200Page.addEditSensor.init().collectData();
        lS1Scout200Page.addEditSensor.delete.init().collectData();
        lS1Scout200Page.addEditSensor.delete.click();
        lS1Scout200Page.dialog.init().click();
        lS1Scout200Page.dialog.okButton.init().collectData().click();
    }

    public void verifyUnits(String arg0)
    {
        List<String> acc = new ArrayList<String>();
        acc.add("mV/m/s²");
        acc.add("mV/g");

        List<String> vel = new ArrayList<String>();
        vel.add("mV/mm/s");
        vel.add("mV/in/s");
        vel.add("mV/m/s");

        List<String> disp = new ArrayList<String>();
        disp.add("mV/μm");
        disp.add("mV/m");
        disp.add("mV/in");
        disp.add("mV/mil");

        List<String> vol=new ArrayList<String>();
        vol.add("mV/V");



        List<String> fin=new ArrayList<String>();
        //fin.add("");

        if(arg0.equals("Acceleration"))
            fin=acc;
        else if(arg0.equals("Velocity"))
            fin=vel;
        else if(arg0.equals("Displacement"))
            fin=disp;
        else if(arg0.equals("Voltage"))
            fin=vol;
        lS1Scout200Page.addEditSensor.init().collectData();
        lS1Scout200Page.addEditSensor.unit.click();
        lS1Scout200Page.senUnit.init().collectData();
        for (int i=1;i<lS1Scout200Page.senUnit.unit.size();i++) {
            Assert.assertTrue(fin.contains(lS1Scout200Page.senUnit.unit.get(i).getText()));
        }

    }
}
