// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.util.Units;

/** Add your docs here. */
public class Constants {

    public static class IntakeConstants {
        // FIXME: ids
        public static final int INTAKE_MOTOR = 0;

        public static final double INTAKE_SPEED = 0;

    }

    public static class IndexerConstants {
        // FIXME: ids
        public static final int INDEXER_MOTOR_LEFT = 9;
        public static final int INDEXER_MOTOR_RIGHT = 8;

        public static final double INDEXER_SPEED = 0.1;

    }

    public static class LauncherConstants {
        public static final int LAUNCHER_MOTOR_LEFT = 7;
        public static final int LAUNCHER_MOTOR_RIGHT = 6;

        // FIXME: velocity
        public static final double LAUNCHER_SPEED_HIGH = 0.1;
        public static final double LAUNCHER_SPEED_LOW = 0;

    }

    public static class OperatorConstants {
        // Joystick Deadband
        public static final double LEFT_X_DEADBAND = 0.1;
        public static final double LEFT_Y_DEADBAND = 0.1;
    }

    public static class LEDConstants {
        public static final int LED_PORT = 9;
    }
}
