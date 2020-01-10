/**-------------------------------------------------------------------------------------
 *| FIRST Robotics Competition                                 .---.        .-----------|
 *| Team 3322                                                 /     \  __  /    ------  |
 *|  ______      ____       _______    __       ______       / /     \(  )/    -----    |
 *| |   ___|    /    \     /   ____\  |  |     |   ___|     //////   ' \/ `   ---       |
 *| |  |_      /  /\  \   |   /  ___  |  |     |  |_       //// / // :    : ---         |
 *| |   _|    /  /__\  \  |  |  |_  | |  |     |   _|     // /   /  /`    '--           |
 *| |  |___  |   ____   | |   \__/  | |  |___  |  |___   //          //..\\             |
 *| |______| |__|    |__|  \_______/  |______| |______|         ====UU====UU====        |
 *|  ______   __      __   ______    ______   ______    ______   __  '/||\` __      __  |
 *| |_    _| |  \    /  | |   __ \  |   ___| |   __ \  |_    _| |  |  |  | |  \    /  | |
 *|   |  |   |   \  /   | |  |__| | |  |_    |  |__| |   |  |   |  |  |  | |   \  /   | |
 *|   |  |   |    \/    | |   ___/  |   _|   |      /    |  |   |  |  |  | |    \/    | |
 *|  _|  |_  |  |\__/|  | |  |      |  |___  |  |\  \   _|  |_  |   \/   | |  |\__/|  | |
 *| |______| |__|    |__| |__|      |______| |__| \__\ |______|  \______/  |__|    |__| |
 * -------------------------------------------------------------------------------------
 */

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class Robot extends TimedRobot {
  public static OI oi;
  public static Shooter shooter;
  public static Limelight limelight;

  @Override
  public void robotInit() {
    oi = new OI();
    shooter = new Shooter();
    limelight = new Limelight();

    shooter.putNumbers();
  }

  @Override
  public void robotPeriodic() {
      SmartDashboard.putNumber("Limelight Distance", Limelight.getDistance());
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
}
@Override
public void teleopInit() {
  SmartDashboard.putNumber("Shooter Speed", 0);
  SmartDashboard.putNumber("Set Shooter RPM", 3000);
}

@Override
public void teleopPeriodic() {
    Scheduler.getInstance().run();
    //shooter.setSpeed(SmartDashboard.getNumber("Shooter Speed", 1));
    shooter.publishRPM();
    shooter.updateConstants();

  }

  @Override
  public void testPeriodic() {
  }
}
