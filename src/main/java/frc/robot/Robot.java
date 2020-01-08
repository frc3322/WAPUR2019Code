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
import frc.robot.subsystems.Shooter;

public class Robot extends TimedRobot {
  public static OI oi;
  public static Shooter shooter;
  

  @Override
  public void robotInit() {
    oi = new OI();
    shooter = new Shooter();
  }

  @Override
  public void robotPeriodic() {
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
private double speed;
@Override
public void teleopInit() {
  SmartDashboard.putNumber("Shooter Speed", speed);
}

@Override
public void teleopPeriodic() {
    Scheduler.getInstance().run();
    shooter.setSpeed(SmartDashboard.getNumber("Shooter Speed", 1));
    shooter.publishRPM();

  }

  @Override
  public void testPeriodic() {
  }
}
