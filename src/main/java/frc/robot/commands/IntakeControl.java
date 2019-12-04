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

    private final int INTAKE_AXIS, REVERSE_AXIS;

    public IntakeControl() {

        // requires(powerwall); //commented out as thor was to lazy to make another subsytem

        INTAKE_AXIS = RobotMap.XBOX.TRIGGER_L_AXIS;
        REVERSE_AXIS = RobotMap.XBOX.TRIGGER_R_AXIS;

    }

    @Override
    protected void execute() {
        
        powerwall.spinIntake(oi.getAboveChassis().getRawAxis(INTAKE_AXIS) - oi.getAboveChassis().getRawAxis(REVERSE_AXIS));
    
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