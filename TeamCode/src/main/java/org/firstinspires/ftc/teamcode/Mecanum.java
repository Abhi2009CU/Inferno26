package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class Mecanum {
    //create motors
    private Motor front_left = new Motor(hardwareMap, "front_left", Motor.GoBILDA.RPM_312);
    private Motor front_right = new Motor(hardwareMap, "front_right", Motor.GoBILDA.RPM_312);
    private Motor back_left = new Motor(hardwareMap, "back_left", Motor.GoBILDA.RPM_312);
    private Motor back_right = new Motor(hardwareMap, "back_right", Motor.GoBILDA.RPM_312);

    //config
    private MecanumDrive mecanum = new MecanumDrive(front_left, front_right, back_left, back_right);

    public Mecanum(){
        mecanum.setRightSideInverted(true);
    }


    public void move(double x, double y, double rotate) {
        double fl = y + x + rotate;
        double fr = y - x - rotate;
        double bl = y - x + rotate;
        double br = y + x - rotate;

        front_left.set(fl);
        front_right.set(fr);
        back_left.set(bl);
        back_right.set(br);
    }
}