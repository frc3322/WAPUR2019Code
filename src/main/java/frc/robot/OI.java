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

public class OI {
  public Joystick chassis = new Joystick(0);
  public Joystick aboveChassis = new Joystick(1);

  //chassis
  
  //above
  Button a_above = new JoystickButton(aboveChassis, RobotMap.XBOX.BUTTON_A);
  Button b_above = new JoystickButton(aboveChassis, RobotMap.XBOX.BUTTON_B);
  Button x_above = new JoystickButton(aboveChassis, RobotMap.XBOX.BUTTON_X);
  Button y_above = new JoystickButton(aboveChassis, RobotMap.XBOX.BUTTON_Y);

  public OI(){
    //chassis

    //above
    a_above.whenPressed(new PowerWallAction("start intake"));
    a_above.whenReleased(new PowerWallAction("stop intake"));

    b_above.whenPressed(new PowerWallAction("reverse intake"));
    b_above.whenReleased(new PowerWallAction("stop intake"));
  }
}
