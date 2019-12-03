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

import static frc.robot.Robot.drivetrain;
import static frc.robot.Robot.oi;

public class DriveControl extends Command {

    private final int SPEED_AXIS;
    private final int ROTATION_AXIS;

    private double rotationModifier;

    private double turnDirection;

    private double speed;

    private double turn;

    private double y;
    private double x;
    private double sX;
    private double sY;
    private double s;
    private double theta;
    private double newX;
    private double newY;
    private double driveLeft;
    private double driveRight;


    public DriveControl() {

        requires(drivetrain);

        SPEED_AXIS = RobotMap.XBOX.STICK_L_Y_AXIS;
        ROTATION_AXIS = RobotMap.XBOX.STICK_R_X_AXIS;

    }

    @Override
    protected void execute() {
        speed = oi.getChassis().getRawAxis(SPEED_AXIS);

        x = oi.getChassis().getRawAxis(ROTATION_AXIS);
        y = oi.getChassis().getRawAxis(SPEED_AXIS);
        
        theta = Math.atan(Math.abs(y)/Math.abs(x));

        if (Math.abs(y) > Math.abs(x)) {
            sY = 1;
            sX = 1 / Math.tan(theta);
            s = sX + sY;
        } else if (Math.abs(x) > Math.abs(y)) {
            sX = 1;
            sY = Math.tan(theta);
            s = sX + sY;
        } else if (Math.abs(x) == Math.abs(y)) {
            s = 2;
        }

        newX = x / s;
        newY = y / s;

        driveLeft = newY - newX;
        driveRight = newY + newX;

        if (Math.abs(x) < 0.05) {
            double avgDrive = (driveLeft+driveRight)/2;
            drivetrain.tankDrive(avgDrive, avgDrive);

        } else {
            drivetrain.tankDrive(driveLeft, driveRight);

        }
    }
        

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        drivetrain.stop();
    }

    @Override
    protected void interrupted() {
        super.interrupted();
    }
}