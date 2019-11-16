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

    public String action;

    public PowerWallAction(String action) {
        requires(powerwall);
        this.action = action;

        /*actions:
            -intake ball
            -shoot ball
            -eject ball
            -stop intake
        */
    }

    @Override
    protected void initialize() {
        if(action == "intake ball"){
            powerwall.toggleIntake();
        } else if (action == "shoot ball"){
            powerwall.start();
        } else if (action == "eject ball"){
            powerwall.reverse();
        } else if (action == "stop intake"){
            powerwall.stop();
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