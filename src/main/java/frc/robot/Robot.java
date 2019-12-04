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
import frc.robot.commands.PowerWallAction;
import frc.robot.subsystems.PowerWall;
import frc.robot.subsystems.Drivetrain;

public class Robot extends TimedRobot {
  public static PowerWall powerwall;
  public static Drivetrain drivetrain;
  public static OI oi;

  @Override
  public void robotInit() {
    powerwall = new PowerWall();
    drivetrain = new Drivetrain();
    oi = new OI();
    powerwall.inputValues();
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

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }
}
