package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

public class Shooter extends PIDSubsystem {

    private static double P = 0.0011;
    private static double I = 0;
    private static double D = 4;
    private static double F = 0.00017;

    private CANSparkMax[] motors = new CANSparkMax[2];
    private CANEncoder[] encoders = new CANEncoder[2];

    private final int MOTOR_0 = 0,
                        MOTOR_1 = 1;

    private final int ENCODER_0 = 0,
                        ENCODER_1 = 1;

    public Shooter() {
        super("Shooter PID", P, I, D, F);

        motors[MOTOR_0] = new CANSparkMax(RobotMap.CAN.SHOOTER_1, MotorType.kBrushless);
        motors[MOTOR_1] = new CANSparkMax(RobotMap.CAN.SHOOTER_2, MotorType.kBrushless);

        encoders[ENCODER_0] = new CANEncoder(motors[MOTOR_0]);
        encoders[ENCODER_1] = new CANEncoder(motors[MOTOR_1]);

        motors[MOTOR_1].follow(motors[MOTOR_0]);

        setAbsoluteTolerance(20);
        setInputRange(0, 5000);
        setOutputRange(0, 1);
        getPIDController().setContinuous(false);
        
        
    }

    @Override
    public void setSetpoint(double setpoint) {
        super.setSetpoint(setpoint);
    }

    public double publishRPM() {
        SmartDashboard.putNumber("Shooter RPM", encoders[ENCODER_0].getVelocity());
        return encoders[ENCODER_0].getVelocity();
    }

    public void setSpeed(double speed) {
        motors[MOTOR_0].set(speed);
    }

    @Override
    protected double returnPIDInput() {
        return encoders[ENCODER_0].getVelocity();
    }

    @Override
    protected void usePIDOutput(double output) {
        SmartDashboard.putNumber("PID Output", output);
        motors[MOTOR_0].pidWrite(output);
    }

    @Override
    protected void initDefaultCommand() {

    }


}