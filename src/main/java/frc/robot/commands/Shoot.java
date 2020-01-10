package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import static frc.robot.Robot.*;

public class Shoot extends Command {

    public Shoot() {

    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        shooter.setSetpoint(SmartDashboard.getNumber("Set Shooter RPM", 3000));
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}