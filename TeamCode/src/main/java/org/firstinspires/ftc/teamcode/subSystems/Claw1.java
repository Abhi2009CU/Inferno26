package org.firstinspires.ftc.teamcode.subSystems;

import com.jumpypants.murphy.RobotContext;
import com.jumpypants.murphy.tasks.Task;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.MyRobot;

public class Claw1{
    //init Servo's
    private final Servo wristServo;
    private final Servo clawServo;

    public static final double wristMaxPos = 0.8, wristMinPos = -0.5, clawClosedPos = 0.1, clawOpenPos = 0.5;

    //Map wristServo and clawServo to teleOp servos
    public Claw1(HardwareMap hardwareMap){
        clawServo = hardwareMap.get(Servo.class, "clawServo");
        wristServo = hardwareMap.get(Servo.class, "wristServo");
    }


    public class MoveClawTask extends Task {
        private final double estTimeTaken;
        private final double targetPosition;


        public MoveClawTask(RobotContext robotContext, double targetPosition) {
            super(robotContext);
            double currentPosition = clawServo.getPosition();
            double TIME_COEF = 0.5;   // seconds per unit distance

            estTimeTaken = Math.abs(targetPosition - currentPosition) * TIME_COEF;
            clawServo.setPosition(targetPosition);

            this.targetPosition = targetPosition;
        }

        @Override
        protected void initialize(RobotContext robotContext) {
            clawServo.setPosition(targetPosition);
        }

        @Override
        protected boolean run(RobotContext robotContext) {
            return ELAPSED_TIME.seconds() < estTimeTaken;
        }
    }
//
//    //set claw pos
//    public void setClawPos(double p) {
//        clawServo.setPosition(Math.max(clawClosedPos, Math.min(clawOpenPos, p)));
//    }

    public class MoveWristTask extends Task {
        private final double estTimeTaken;
        private final double targetPosition;

        public MoveWristTask(RobotContext robotContext, double targetPosition) {
            super(robotContext);
            double currentPosition = wristServo.getPosition();
            double TIME_COEF = 0.5;   // seconds per unit distance

            estTimeTaken = Math.abs(targetPosition - currentPosition) * TIME_COEF;
            wristServo.setPosition(targetPosition);

            this.targetPosition = targetPosition;
        }

        @Override
        protected void initialize(RobotContext robotContext) {
            wristServo.setPosition(targetPosition);
        }

        @Override
        protected boolean run(RobotContext robotContext) {
            return ELAPSED_TIME.seconds() < estTimeTaken;
        }
    }
    //set wrist pos
    public void setWristPos(double p){
        wristServo.setPosition(Math.max(wristMinPos, Math.min(wristMaxPos, p)));
    }
}