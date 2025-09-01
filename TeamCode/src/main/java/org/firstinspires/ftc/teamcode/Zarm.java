package org.firstinspires.ftc.teamcode;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.controller.PIDController;

public class Zarm {
    //create slideMotor
    private Motor slideMotor;

    //init max and min pos
    public static final double MAX_POS = 4.0;
    public static final double MIN_POS = 0.0;

    //init PID variables
    public static final double PID_P = 0.001;
    public static final double PID_I = 0.0001;
    public static final double PID_D = 0.004;

    //init slideMotorPID
    private final PIDController slideMotorPID = new PIDController(PID_P, PID_I, PID_D);

    //init slideMotor
    public Zarm(Motor slideMotor){
        this.slideMotor = slideMotor;
        this.slideMotor.setRunMode(Motor.RunMode.RawPower);
        this.slideMotor.resetEncoder();
    }
    
    public void setPos(double p){
        slideMotorPID.setPoint(Math.max(MIN_POS, Math.min(MAX_POS, p)));
    }
    
    public void tickPID(){
        slideMotor.set((Math.max(-1, Math.min(1, pidController.calculate(slideMotorgetCurrentPosition())))));
    }



}

