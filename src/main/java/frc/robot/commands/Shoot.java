package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import static frc.robot.Robot.*;

public class Shoot extends Command {

    public Shoot() {

    }

    @Override
    protected void initialize() {
        super.initialize();
        shooter.enable();
    }

    @Override
    protected void execute() {
        shooter.setSetpoint(3000);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}