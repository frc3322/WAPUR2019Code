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

    private final int LEFT_BACK = 0,
                      LEFT_FRONT = 1,
                      RIGHT_BACK = 2,
                      RIGHT_FRONT = 3;

    private AHRS navx;

    private CANSparkMax[] motors = new CANSparkMax[4];

    private CANEncoder[] encoders = new CANEncoder[4];

    private double rampRate = .4;

    public Drivetrain() {
        
        navx = new AHRS(SPI.Port.kMXP);

        motors[LEFT_BACK] = new CANSparkMax(RobotMap.CAN.LEFT_BACK_MOTOR, MotorType.kBrushless);
        motors[LEFT_FRONT] = new CANSparkMax(RobotMap.CAN.LEFT_FRONT_MOTOR, MotorType.kBrushless);
        motors[RIGHT_BACK] = new CANSparkMax(RobotMap.CAN.RIGHT_BACK_MOTOR, MotorType.kBrushless);
        motors[RIGHT_FRONT] = new CANSparkMax(RobotMap.CAN.RIGHT_FRONT_MOTOR, MotorType.kBrushless);

        encoders[LEFT_BACK] = motors[LEFT_BACK].getEncoder();
        encoders[LEFT_FRONT] = motors[LEFT_FRONT].getEncoder();
        encoders[RIGHT_BACK] = motors[RIGHT_BACK].getEncoder();
        encoders[RIGHT_FRONT] = motors[RIGHT_FRONT].getEncoder();

        robotDrive = new DifferentialDrive(motors[LEFT_FRONT], motors[RIGHT_FRONT]);
        motors[LEFT_BACK].follow(motors[LEFT_FRONT]);
        motors[RIGHT_BACK].follow(motors[RIGHT_FRONT]);

        motors[LEFT_FRONT].setOpenLoopRampRate(rampRate);
        motors[RIGHT_FRONT].setOpenLoopRampRate(rampRate);

        motors[LEFT_FRONT].setSmartCurrentLimit(40);
        motors[RIGHT_FRONT].setSmartCurrentLimit(40);
        motors[LEFT_BACK].setSmartCurrentLimit(40);
        motors[RIGHT_BACK].setSmartCurrentLimit(40);
    
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