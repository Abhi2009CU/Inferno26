package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.motors.Motor;

public class Xarm {
    //init slideMotor
    private final Motor slideMotor;

    //init max and min pos and power
    public static final double MAX_POS = 4.0;
    public static final double MIN_POS = 0.0;
    public static final double MAX_PWR = 1.0;
    public static final double MIN_PWR = -1.0;

    //map slideMotor to hardware from teleOp
    public Xarm(Motor slideMotor){
        this.slideMotor = slideMotor;
        this.slideMotor.setRunMode(Motor.RunMode.RawPower);
        this.slideMotor.resetEncoder();
    }

    //set slideMotor speed
    public void setSpeed(double s) {
        double currentPos = slideMotor.getCurrentPosition();
        //if moving up when at max pos OR if moving down
        //when at min pos do nothing
        if (s > 0 && currentPos => MAX_POS){
            return;
        }else if (s < 0 && currentPos <= MIN_POS){
            return;
        }
        //else set motor power
        slideMotor.set(Math.max(MIN_PWR, Math.min(MAX_PWR, s)));
    }


}

