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

import static frc.robot.Robot.powerwall;

public class PowerWallAction extends Command{
    
    public enum action {
        INTAKE,
        SHOOT,
        EJECT,
        STOP;
    }

    action status;

    public PowerWallAction(action status) {
        
        // requires(powerwall); //commented out as thor was to lazy to make another subsytem
        this.status = status;

        /*actions:
            -shoot ball
            -eject ball
            -stop intake
        */
    }

    // Hi this is Efe making sure I can push to Github.
    @Override
    protected void initialize() {
        switch(status) {
            case INTAKE:
                powerwall.spinIntake(SmartDashboard.getNumber("Intake Speed", powerwall.getDefaultIntakeSpeed()));
                break;
            case SHOOT:
                powerwall.start();
                break;
            case EJECT:
                powerwall.reverse();
                break;
            case STOP:
                powerwall.stop();
                break;
        }
    }

    @Override
    protected void execute() {
        
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
    }

}