package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImpl;

public class Claw{
    private Servo wristServo = hardwareMap.get(Servo.class, "wristServo");;
    private Servo clawServo = hardwareMap.get(Servo.class, "clawServo");;
    public double wristMaxPos, wristMinPos, clawClosedPos, clawOpenPos;

    public void setClawPos(double p) {
        clawServo.setPosition(Math.max(clawClosedPos, Math.min(clawOpenPos, p)));
    }

    public void setWristPos(double p){
        wristServo.setPosition(Math.max(wristMinPos, Math.min(wristMaxPos, p)));
    }
}
