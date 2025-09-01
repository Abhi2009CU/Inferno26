package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImpl;

public class Claw{
    //init Servo's
    private Servo wristServo;
    private Servo clawServo;

    //Map wristServo and clawServo to teleOp servos
    public Claw(Servo wristServo, Servo clawServo){
        this.wristServo = wristServo;
        this.clawServo = clawServo;
    }

    // init servo max and min pos
    public double wristMaxPos = 0.8, wristMinPos = -0.5, clawClosedPos = 0.1, clawOpenPos = 0.5;

    //set claw pos
    public void setClawPos(double p) {
        clawServo.setPosition(Math.max(clawClosedPos, Math.min(clawOpenPos, p)));
    }

    //set wrist pos
    public void setWristPos(double p){
        wristServo.setPosition(Math.max(wristMinPos, Math.min(wristMaxPos, p)));
    }
}
