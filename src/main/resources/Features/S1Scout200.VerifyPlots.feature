
 Feature: Software Only

	Scenario Outline:  {724999} Plots are using the correct unit of measure
		Given the app is launched
		When user clicks "ACCEPT" on license alert page "S1Scout200.LicenseAlert:uiJSON"
		And user clicks "OK" on hazard alert page "S1Scout200.HazardAlert:uiJSON"
		And user clicks "OK" on device compatibility alert page "S1Scout200.DeviceCompatibilityAlert:uiJSON"
		And user navigates to homePage "S1Scout200.S1Scout200Page:uiJSON"
		And user enables Data Collector Simulator "On"
		And user enables simulator on devices
		And user navigates Settings Measuring Units
		And user selects <units> in "Unit Set"
		And user navigates to "Measure"
		And Select any continuous data collection measurement <measurementType>
		And a new Parameter set with Store Unit <parameterSet>
		And Add a new sensor
		And Select the "name" property
		And Input a name for the sensor and then commit the changes "Test"
		And Change the sensor type to <parameterSet>
		And Save the sensor configuration "CH1"
		And navigates back
		And user clicks on Measure on Measure Configuration Screen
		And user pauses the measurement
		And user verifies measure units <spectrumUnit> and <WaveformUnit>
		
		Then user quits the app
		
	Examples:
		| units | measurementType | parameterSet | spectrumUnit | WaveformUnit |
		|S.I | Spectrum/Waveform | Acceleration | m/s^2 rms | m/s^2 0-pk |
		|S.I | Spectrum/Waveform |Velocity|mm/s rms|mm/s 0-pk|
		|S.I|Spectrum/Waveform|Displacement|um rms|um 0-pk|
		|U.S|Spectrum/Waveform|Acceleration|g 0-pk|g 0-pk|
		