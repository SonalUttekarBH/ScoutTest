
Feature: Software Only

	Scenario:  {721068}Sensor Configuration
		Given the app is launched
		When user clicks "OK" on device compatibility alert page "S1Scout200.DeviceCompatibilityAlert:uiJSON"
		And user resets the database
		And user navigates to homePage "S1Scout200.S1Scout200Page:uiJSON"
		And user enables Data Collector Simulator "On"
		And user enables simulator on devices
		And user navigates to "Measure"
		And Select any continuous data collection measurement "Spectrum / Waveform"
		And Add a new sensor "CH1"
		And Select the "name" property
		And Input a name for the sensor and then commit the changes "DemoSensor" and ""
		And Change the Voltage Range and Coupling to be of "DC" Coupling type
		And Modify the Zero DC Offset property "20"
		And Change the sensor type to each of the available sensor settings
			|Acceleration|
			|Velocity    |
			|Voltage     |
			|Displacement|
		And Change the Voltage Range and Coupling to be of "AC" Coupling type
		And Modify the Units property "mV/m"
		And Modify the Settling Time property "20"
		And Modify the Auto Settling property "On"
		And Modify the Sensitivity property "20"
		And Modify the Drive Current property "On"
		And Save the sensor configuration "CH1"
		And Select any channel to setup the sensor configuration "CH2"
		And Edit the previously configured sensor "DemoSensor"
		And Modify all properties of the sensor to some other value within limits
		And Save the sensor configuration "CH2"
		And Select any channel to setup the sensor configuration "CH2"
		And Delete the sensor "DemoSensor"
		And Navigate back to the channel selection screen
		Then user quits the app




