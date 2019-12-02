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
        requires(powerwall);
        this.status = status;

        /*actions:
            -intake ball
            -shoot ball
            -eject ball
            -stop intake
        */
    }


    @Override
    protected void initialize() {
        switch(status) {
            case INTAKE:
                powerwall.toggleIntake();
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