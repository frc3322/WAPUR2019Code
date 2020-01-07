/**
 *  _____    _____     _____     _____   
 * |___  \  |___  \   /  _  \   /  _  \
 *  ___|  |  ___|  | |__| |  | |__| |  |
 * |___   | |___   |     /  /      /  /
 *  ___|  |  ___|  |   /  /__    /  /__
 * |_____/  |_____/   |______|  |______|
 *
 */

package frc.robot;

public class RobotMap {
  public static class CAN {
    //drivetrain
    public static final int FRONT_LEFT_MOTOR = 0;
    public static final int FRONT_RIGHT_MOTOR = 1;
    public static final int BACK_RIGHT_MOTOR = 34;
    public static final int BACK_LEFT_MOTOR = 35;
    
    public static final int POWERWALL_FRONT_MOTOR_1 = 13;
    public static final int POWERWALL_FRONT_MOTOR_2 = 21;
    public static final int POWERWALL_BACK_MOTOR_1 = 22;
    public static final int POWERWALL_BACK_MOTOR_2 = 23;
    public static final int POWERWALL_INTAKE_MOTOR = 11;
    public static final int POWERWALL_TILT_MOTOR_1 = 12;
    public static final int POWERWALL_TILT_MOTOR_2 = 10;

    public static final int SHOOTER_1 = 46;
    public static final int SHOOTER_2 = 37;
  }

  public static class PCM {
    public static final int PCM_ID = 0;

    public static final int INTAKE_EXTEND = 6;
    public static final int INTAKE_RETRACT = 7;
  }

  public static class XBOX {
    // Buttons
    public static final int BUTTON_A = 1;
    public static final int BUTTON_B = 2;
    public static final int BUTTON_X = 3;
    public static final int BUTTON_Y = 4;
    public static final int BUMPER_LEFT = 5;
    public static final int BUMPER_RIGHT = 6;
    public static final int BUTTON_BACK = 7;
    public static final int BUTTON_START = 8;
    public static final int STICK_LEFT = 9;
    public static final int STICK_RIGHT = 10;

    // Axes
    public static final int STICK_L_X_AXIS = 0;
    public static final int STICK_L_Y_AXIS = 1;
    public static final int STICK_R_X_AXIS = 4;
    public static final int STICK_R_Y_AXIS = 5;
    public static final int TRIGGER_L_AXIS = 2;
    public static final int TRIGGER_R_AXIS = 3;
  }
}
