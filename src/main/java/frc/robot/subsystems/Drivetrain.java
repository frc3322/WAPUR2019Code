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

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.RobotMap;
import frc.robot.commands.DriveControl;

public class Drivetrain extends Subsystem {
  
    private DifferentialDrive robotDrive;

    private final int BACK_LEFT = 0,
                      BACK_RIGHT = 1,
                      FRONT_LEFT = 2,
                      FRONT_RIGHT = 3;

    private AHRS navx;

    private CANSparkMax[] motors = new CANSparkMax[4];

    private CANEncoder[] encoders = new CANEncoder[4];

    private double rampRate = .4;

    public Drivetrain() {
        
        navx = new AHRS(SPI.Port.kMXP);

        motors[BACK_LEFT] = new CANSparkMax(RobotMap.CAN.BACK_LEFT_MOTOR, MotorType.kBrushless);
        motors[BACK_RIGHT] = new CANSparkMax(RobotMap.CAN.BACK_RIGHT_MOTOR, MotorType.kBrushless);
        motors[FRONT_LEFT] = new CANSparkMax(RobotMap.CAN.FRONT_LEFT_MOTOR, MotorType.kBrushless);
        motors[FRONT_RIGHT] = new CANSparkMax(RobotMap.CAN.FRONT_RIGHT_MOTOR, MotorType.kBrushless);

        encoders[BACK_LEFT] = motors[BACK_LEFT].getEncoder();
        encoders[BACK_RIGHT] = motors[BACK_RIGHT].getEncoder();
        encoders[FRONT_LEFT] = motors[FRONT_LEFT].getEncoder();
        encoders[FRONT_RIGHT] = motors[FRONT_RIGHT].getEncoder();

        robotDrive = new DifferentialDrive(motors[BACK_RIGHT], motors[FRONT_RIGHT]);
        motors[BACK_LEFT].follow(motors[BACK_RIGHT]);
        motors[FRONT_LEFT].follow(motors[FRONT_RIGHT]);

        motors[FRONT_LEFT].setOpenLoopRampRate(rampRate);
        motors[FRONT_RIGHT].setOpenLoopRampRate(rampRate);

        motors[FRONT_LEFT].setSmartCurrentLimit(40);
        motors[FRONT_RIGHT].setSmartCurrentLimit(40);
        motors[BACK_LEFT].setSmartCurrentLimit(40);
        motors[BACK_RIGHT].setSmartCurrentLimit(40);
    
    }

    public void update() {
        //SmartDashboard.putNumber("WheelRPM Left", wheelRPM(LEFT_FRONT));
        //SmartDashboard.putNumber("WheelRPM Right", wheelRPM(RIGHT_FRONT));
        //SmartDashboard.putBoolean("Is High Gear", isClimbUp());
        //SmartDashboard.putBoolean("Is Low Gear", isClimbDown());
        // SmartDashboard.putNumber("Encoder Left", getEncoder(LEFT_FRONT));
        // SmartDashboard.putNumber("Encoder Right", getEncoder(RIGHT_FRONT));
        // SmartDashboard.putNumber("Drivetrain Angle", navx.getYaw());
    }

    public double getVoltage(int n) {
        return motors[n].getBusVoltage();
    }

    public double getMotorHeat(int n) {
        return motors[n].getMotorTemperature();
    }

    public double getOutputCurrent(int n) {
        return motors[n].getOutputCurrent();
    }

    public double getEncoder(int n) {
        return encoders[n].getPosition();
    }

    public double getVelocity(int n) {
        return encoders[n].getVelocity();
    }

    public void drive(double speed, double rotation){
        robotDrive.arcadeDrive(speed, rotation);

    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        robotDrive.tankDrive(leftSpeed, rightSpeed);
    }

    public void stop(){
        drive(0, 0);
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new DriveControl());
    }

    public double getAngle(){
        return navx.getAngle();
    }

    public void setRampRate(double rampRate){

        this.rampRate = rampRate;

    }

}