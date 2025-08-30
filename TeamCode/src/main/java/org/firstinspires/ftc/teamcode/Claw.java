package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImpl;

public class Claw{
    //init Servo's
    private Servo wristServo = hardwareMap.get(Servo.class, "wristServo");;
    private Servo clawServo = hardwareMap.get(Servo.class, "clawServo");;

    // init servo max and min pos
    public double wristMaxPos, wristMinPos, clawClosedPos, clawOpenPos;

    //set claw pos
    public void setClawPos(double p) {
        clawServo.setPosition(Math.max(clawClosedPos, Math.min(clawOpenPos, p)));
    }

    //set wrist pos
    public void setWristPos(double p){
        wristServo.setPosition(Math.max(wristMinPos, Math.min(wristMaxPos, p)));
    }
}
