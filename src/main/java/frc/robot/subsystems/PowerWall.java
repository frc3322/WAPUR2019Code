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
import frc.robot.commands.IntakeControl;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class PowerWall extends Subsystem{

    WPI_TalonSRX frontMotor1;
    WPI_TalonSRX frontMotor2;
    WPI_TalonSRX backMotor1;
    WPI_TalonSRX backMotor2; 
    
    WPI_TalonSRX intakeMotor;
    WPI_TalonSRX intakeTilt1;
    WPI_TalonSRX intakeTilt2;
    //DoubleSolenoid intakeExtender = new DoubleSolenoid(RobotMap.PCM.PCM_ID, RobotMap.PCM.INTAKE_EXTEND, RobotMap.PCM.INTAKE_RETRACT);

    private double defaultPowerWallSpeed;
    private double defaultIntakeSpeed;

    public PowerWall() {
        frontMotor1 = new WPI_TalonSRX(RobotMap.CAN.POWERWALL_FRONT_MOTOR_1);
        frontMotor2 = new WPI_TalonSRX(RobotMap.CAN.POWERWALL_FRONT_MOTOR_2);
        backMotor1 = new WPI_TalonSRX(RobotMap.CAN.POWERWALL_BACK_MOTOR_1);
        backMotor2 = new WPI_TalonSRX(RobotMap.CAN.POWERWALL_BACK_MOTOR_2);

        intakeMotor = new WPI_TalonSRX(RobotMap.CAN.POWERWALL_INTAKE_MOTOR);
        intakeTilt1 = new WPI_TalonSRX(RobotMap.CAN.POWERWALL_TILT_MOTOR_1);
        intakeTilt2 = new WPI_TalonSRX(RobotMap.CAN.POWERWALL_TILT_MOTOR_2);

        defaultPowerWallSpeed = 0.9;
        defaultIntakeSpeed = 0.2;
        
 
        frontMotor2.setInverted(true);
        frontMotor2.follow(frontMotor1);
        backMotor2.setInverted(true);
        backMotor2.follow(backMotor1);

        intakeMotor.configPeakCurrentLimit(60, 10);
        intakeMotor.configPeakCurrentDuration(20, 10);
        intakeMotor.configContinuousCurrentLimit(40, 10);
        intakeMotor.enableCurrentLimit(true);

        //WPI_TalonSRX[] motors = {frontMotor1, frontMotor2, backMotor1, backMotor2};

        /*for(WPI_TalonSRX motor: motors){
            
            motor.configPeakCurrentLimit(60, 10);
            motor.configPeakCurrentDuration(20, 10);
            motor.configContinuousCurrentLimit(40, 10);
            motor.enableCurrentLimit(true);

        }*/


    }

    public double getDefaultIntakeSpeed(){
        return defaultIntakeSpeed;
    }

    public void inputValues(){
        SmartDashboard.putNumber("PowerWall Front Speed", defaultPowerWallSpeed);
        SmartDashboard.putNumber("PowerWall Back Speed", -defaultPowerWallSpeed);
        SmartDashboard.putNumber("Intake Speed", defaultIntakeSpeed);
    }

    public void spinIntake(double speed){
        intakeMotor.set(speed);
    }

    public void tiltIntake(double speed){
        intakeTilt1.set(speed);
        intakeTilt2.set(-speed);
    }

    public void start() {
        frontMotor1.set(SmartDashboard.getNumber("PowerWall Front Speed", defaultPowerWallSpeed));
        backMotor1.set(SmartDashboard.getNumber("PowerWall Back Speed", -defaultPowerWallSpeed));
    }

    public void stop() {
        frontMotor1.set(0);
        backMotor1.set(0);
        intakeMotor.set(0);
    }

    public void reverse() {
        frontMotor1.set(-defaultPowerWallSpeed);
        backMotor1.set(defaultPowerWallSpeed);
    }

    @Override
    protected void initDefaultCommand() {

        setDefaultCommand(new IntakeControl());

    }
}
