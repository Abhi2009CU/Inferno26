package org.firstinspires.ftc.teamcode;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.controller.PIDController;


public class Zarm {
    private Motor slideMotor;
    
    slideMotor.setRunMode(Motor.RunMode.RawPower);
    slideMotor.resetEncoder();
    
    public double MAX_POS, MIN_POS;
    private PIDController SLIDE_PID;
    
    PIDController pidController = new PIDController(0.2,0.1, 0.1);
    
    public void setPos(double p){
        slideMotor.set(Math.max(MIN_POS, Math.min(MAX_POS, p)));
    }
    
    public void tickPID(){
        slideMotor.set(pidController.calculate(slideMotor.encoder.getPosition()));
    }



}

