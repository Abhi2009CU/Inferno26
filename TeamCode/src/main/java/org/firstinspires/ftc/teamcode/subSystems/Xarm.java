package org.firstinspires.ftc.teamcode.subSystems;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.jumpypants.murphy.RobotContext;
import com.jumpypants.murphy.tasks.Task;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Xarm {

    private final Motor SLIDE_MOTOR;

    public static final double MAX_POS = 1000.0;
    public static final double MIN_POS = 0.0;
    public static final double MAX_PWR = 1.0;
    public static final double MIN_PWR = -1.0;

    public Xarm(HardwareMap hardwareMap){
        SLIDE_MOTOR = new Motor(hardwareMap, "extensionMotor");
        SLIDE_MOTOR.setRunMode(Motor.RunMode.RawPower);
        SLIDE_MOTOR.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        SLIDE_MOTOR.resetEncoder();
    }

    public void setSpeed(double s, RobotContext robotContext) {
        double currentPos = SLIDE_MOTOR.getCurrentPosition();

        if (s > 0 && currentPos >= MAX_POS) {
            return;
        } else if (s < 0 && currentPos <= MIN_POS) {
            return;
        }

        SLIDE_MOTOR.set(Math.max(MIN_PWR, Math.min(MAX_PWR, s)));
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
            double currPos = SLIDE_MOTOR.getCurrentPosition();
            return Math.abs(MAX_POS - currPos) > 5;  // tolerance of 5 ticks
        }
    }

}

