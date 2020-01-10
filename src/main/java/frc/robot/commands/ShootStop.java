package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import static frc.robot.Robot.*;

public class ShootStop extends Command {

    public ShootStop() {

    }

    @Override
    protected void initialize() {
        //shooter.stop();
        shooter.setSetpoint(0);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}