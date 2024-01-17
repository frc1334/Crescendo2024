// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LEDConstants;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;


public class LEDSubsystem extends SubsystemBase {
  AddressableLED ledStrip;
  AddressableLEDBuffer ledBuffer;

  /** Creates a new LEDSubsystem. */
  public LEDSubsystem() {
    ledStrip = new AddressableLED(LEDConstants.LED_PORT);
    ledBuffer = new AddressableLEDBuffer(100);
    ledStrip.setLength(ledBuffer.getLength());
    ledStrip.setData(ledBuffer);
    ledStrip.start();
  }


  public void rainbow() {
    int rainbowFirstPixelHue = 5;
    // For every pixel
    for (var i = 0; i < ledBuffer.getLength(); i++) {
      // Calculate the hue - hue is easier for rainbows because the color
      // shape is a circle so only one value needs to precess
      final var hue = (rainbowFirstPixelHue + (i * 180 / ledBuffer.getLength())) % 180;
      // Set the value
      ledBuffer.setHSV(i, hue, 255, 128);
    }
    // Increase by to make the rainbow "move"
    rainbowFirstPixelHue += 3;
    // Check bounds
    rainbowFirstPixelHue %= 180;
    ledStrip.setData(ledBuffer);
  }


  public void ledColour(int colour) {
    int r = (colour >> 16) & 0xFF;
    int g = (colour >> 8) & 0xFF;
    int b = colour & 0xFF;

    for (int i = 0; i < ledBuffer.getLength(); i++) {
      ledBuffer.setRGB(i, r, g, b);
    }
    ledStrip.setData(ledBuffer);
  }


  public void rainbowWave() {
    // Get the current time in milliseconds
    long currentTime = System.currentTimeMillis();

    // Define the speed of the wave (adjust as needed)
    double waveSpeed = 0.1;

    // Loop through each LED in the strip
    for (int i = 0; i < ledBuffer.getLength(); i++) {
        // Calculate hue based on position and time
        float hue = (float) ((i + currentTime * waveSpeed) % 360.0);

        // Convert HSV to RGB
        int rgb = java.awt.Color.HSBtoRGB(hue / 360.0f, 1.0f, 1.0f);

        // Extract individual color components
        int r = (rgb >> 16) & 0xFF;
        int g = (rgb >> 8) & 0xFF;
        int b = rgb & 0xFF;

        // Set the color for the current LED
        ledBuffer.setRGB(i, r, g, b);
    }

    // Update the LED strip with the new colors
    ledStrip.setData(ledBuffer);
}


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
