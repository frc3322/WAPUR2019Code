/**
 *  _____    _____     _____     _____   
 * |___  \  |___  \   /  _  \   /  _  \
 *  ___|  |  ___|  | |__| |  | |__| |  |
 * |___   | |___   |     /  /      /  /
 *  ___|  |  ___|  |   /  /__    /  /__
 * |_____/  |_____/   |______|  |______|
 *
 */

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

import static frc.robot.Robot.powerwall;
import static frc.robot.Robot.oi;

public class IntakeControl extends Command {

    private final int TILT_AXIS, REVERSE_TILT_AXIS, SPIN_AXIS;

    public IntakeControl() {

        requires(powerwall);

        TILT_AXIS = RobotMap.XBOX.TRIGGER_L_AXIS;
        REVERSE_TILT_AXIS = RobotMap.XBOX.TRIGGER_R_AXIS;
        SPIN_AXIS = RobotMap.XBOX.STICK_L_Y_AXIS;

    }

    @Override
    protected void execute() {
        
        powerwall.tiltIntake(oi.getAboveChassis().getRawAxis(TILT_AXIS) - oi.getAboveChassis().getRawAxis(REVERSE_TILT_AXIS));
        //powerwall.spinIntake((oi.getAboveChassis().getRawAxis(SPIN_AXIS)) / 10);
    
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        powerwall.spinIntake(0);
    }

    @Override
    protected void interrupted() {
        super.interrupted();
    }
}