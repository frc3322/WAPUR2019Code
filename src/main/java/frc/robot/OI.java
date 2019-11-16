/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

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

  public OI(){
    //chassis

    //above
    a_above.whenPressed(new PowerWallAction("start intake"));
    a_above.whenReleased(new PowerWallAction("stop intake"));

    b_above.whenPressed(new PowerWallAction("reverse intake"));
    b_above.whenReleased(new PowerWallAction("stop intake"));
  }
}
