/**
 *  _____    _____     _____     _____   
 * |___  \  |___  \   /  _  \   /  _  \
 *  ___|  |  ___|  | |__| |  | |__| |  |
 * |___   | |___   |     /  /      /  /
 *  ___|  |  ___|  |   /  /__    /  /__
 * |_____/  |_____/   |______|  |______|
 *
 */

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class PowerWall extends Subsystem{

    WPI_TalonSRX frontMotor = new WPI_TalonSRX(RobotMap.CAN.POWERWALL_FRONT_MOTOR);
    WPI_TalonSRX backMotor = new WPI_TalonSRX(RobotMap.CAN.POWERWALL_BACK_MOTOR);
    DoubleSolenoid intakeExtender = new DoubleSolenoid(RobotMap.PCM.PCM_ID, RobotMap.PCM.INTAKE_EXTEND, RobotMap.PCM.INTAKE_RETRACT);

    public PowerWall() {
    }

    public void inputValues(){
        SmartDashboard.putNumber("PowerWall Front Speed", 0.45);
        SmartDashboard.putNumber("PowerWall Back Speed", 0.45);
    }

    public void start() {
        frontMotor.set(SmartDashboard.getNumber("PowerWall Front Speed", 0.45));
        backMotor.set(SmartDashboard.getNumber("PowerWall Back Speed", 0.45));
    }

    public void stop() {
        frontMotor.set(0);
        backMotor.set(0);
    }

    public void reverse() {
        frontMotor.set(-1);
        backMotor.set(-1);
    }

    public void intakeExtend() {
        intakeExtender.set(DoubleSolenoid.Value.kForward);
    }

    public void intakeRetract() {
        intakeExtender.set(DoubleSolenoid.Value.kReverse);
    }

    public void toggleIntake() {
        if(intakeExtended()) {
            intakeRetract();
        }else{
            intakeExtend();
        }
    }

    public boolean intakeExtended() {
        return intakeExtender.get() == Value.kForward;
    }

    @Override
    protected void initDefaultCommand() {

    }
}
