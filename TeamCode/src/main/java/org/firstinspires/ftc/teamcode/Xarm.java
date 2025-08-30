package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.motors.Motor;

public class Xarm {
    private Motor motor;

    public double FORWARD_MAX_POWER = 1;

    public double MAX_POS;
    public double MIN_POS;

    public void setSpeed(double s) {
        double currentPos = slideMotor.getCurrentPosition();
        if (s > 0 && currentPos => MAX_POS){
            return;
        }
        if (s < 0 && currentPos <= MIN_POS){
            return;
        }
        motor.set(Math.max(MIN_POS, Math.min(MAX_POS, s)));
    }


}

