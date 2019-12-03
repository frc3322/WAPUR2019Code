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

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;
import frc.robot.commands.PowerWallAction.action;

public class OI {
  private Joystick chassis = new Joystick(0);
  private Joystick aboveChassis = new Joystick(1);

  //chassis
  
  //above
  Button a_above = new JoystickButton(aboveChassis, RobotMap.XBOX.BUTTON_A);
  Button b_above = new JoystickButton(aboveChassis, RobotMap.XBOX.BUTTON_B);
  Button x_above = new JoystickButton(aboveChassis, RobotMap.XBOX.BUTTON_X);
  Button y_above = new JoystickButton(aboveChassis, RobotMap.XBOX.BUTTON_Y);

  public OI(){
    //chassis

    //above
    a_above.whenPressed(new PowerWallAction(action.SHOOT));
    a_above.whenReleased(new PowerWallAction(action.STOP));

    b_above.whenPressed(new PowerWallAction(action.EJECT));
    b_above.whenReleased(new PowerWallAction(action.STOP));
  }

  public Joystick getChassis(){
    return chassis;
  }

  public Joystick getAboveChassis(){
    return aboveChassis;
  }

}
