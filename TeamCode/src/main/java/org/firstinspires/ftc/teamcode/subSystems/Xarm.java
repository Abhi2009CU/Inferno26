package org.firstinspires.ftc.teamcode.subSystems;

import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.jumpypants.murphy.RobotContext;
import com.jumpypants.murphy.tasks.Task;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Xarm {
    //init slideMotor
    private final Motor slideMotor;

    //init max and min pos and power
    public static final double MAX_POS = 1000.0;
    public static final double MIN_POS = 0.0;
    public static final double MAX_PWR = 1.0;
    public static final double MIN_PWR = -1.0;

    //map slideMotor to hardware from teleOp
    public Xarm(HardwareMap hardwareMap){
        slideMotor = new Motor(hardwareMap, "extensionMotor");
        slideMotor.setRunMode(Motor.RunMode.RawPower);
        slideMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        slideMotor.resetEncoder();
    }

    //set slideMotor speed
    public void setSpeed(double s, RobotContext robotContext) {
        double currentPos = slideMotor.getCurrentPosition();
        //if moving up when at max pos OR if moving down
        //when at min pos do nothing
        if (s > 0 && currentPos >= MAX_POS) {
            return;
        } else if (s < 0 && currentPos <= MIN_POS) {
            return;
        }
        //else set motor power
        slideMotor.set(Math.max(MIN_PWR, Math.min(MAX_PWR, s)));
    }

    public class MoveSlideMotor extends Task {

        public MoveSlideMotor(RobotContext robotContext){
            super(robotContext);
        }

        @Override
        protected void initialize(RobotContext robotContext) {

        }

        @Override
        protected boolean run(RobotContext robotContext) {
            double currPos = slideMotor.getCurrentPosition();
            return Math.abs(MAX_POS - currPos) > 5;  // tolerance of 5 ticks
        }
    }

}

