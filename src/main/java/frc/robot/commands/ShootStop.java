package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import static frc.robot.Robot.*;

public class ShootStop extends Command {

    public ShootStop() {

    }

    @Override
    protected void initialize() {
        super.initialize();
        shooter.disable();
        shooter.setSpeed(0);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}