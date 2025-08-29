package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.motors.Motor;

public class Xarm {
    private Motor motor;

    public double FORWARD_MAX_POWER = 1;

    public double MAX_POS;
    public double MIN_POS;

    public void setSpeed(double s) {
        motor.set(Math.max(MIN_POS, Math.min(MAX_POS, s)));
    }


}
