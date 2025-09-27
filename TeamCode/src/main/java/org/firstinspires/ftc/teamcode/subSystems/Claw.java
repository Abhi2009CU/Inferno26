package org.firstinspires.ftc.teamcode.subSystems;

import com.jumpypants.murphy.RobotContext;
import com.jumpypants.murphy.tasks.Task;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {
    private final Servo CLAW_SETRVO;
    private final Servo WRIST_SERVO;

    public static final double CLAW_CLOSED_POS = 0.0;
    public static final double CLAW_OPEN_POS = 1.0;

    public static final double WRIST_CLOSED_POS = 0.0;
    public static final double WRIST_OPEN_POS = 1.0;

    public Claw(HardwareMap hardwareMap) {
        CLAW_SETRVO = hardwareMap.get(Servo.class, "clawServo");
        WRIST_SERVO = hardwareMap.get(Servo.class, "wristServo");
    }

    public class MoveClawTask extends Task{
        private final double TARGET_POSITION;
        private final double ESTIMATED_TIME_TAKEN;
        public MoveClawTask(RobotContext robotContext, double targetPosition) {
            super(robotContext);
            this.TARGET_POSITION = targetPosition;
            ESTIMATED_TIME_TAKEN = Math.abs(TARGET_POSITION - CLAW_SETRVO.getPosition()) * 0.5;
            CLAW_SETRVO.setPosition(targetPosition);
        }

        @Override
        protected void initialize(RobotContext robotContext) {
            CLAW_SETRVO.setPosition(TARGET_POSITION);
        }

        @Override
        protected boolean run(RobotContext robotContext) {
            return ELAPSED_TIME.seconds() < ESTIMATED_TIME_TAKEN;
        }
    }

    public class MoveWristTask extends Task{

        private final double TARGET_POSITION;
        private final double ESTIMATED_TIME_TAKEN;
        public MoveWristTask(RobotContext robotContext, double targetPosition) {
            super(robotContext);
            this.TARGET_POSITION = targetPosition;
            ESTIMATED_TIME_TAKEN = Math.abs(TARGET_POSITION - CLAW_SETRVO.getPosition()) * 0.5;
            WRIST_SERVO.setPosition(targetPosition);
        }

        @Override
        protected void initialize(RobotContext robotContext) {
            WRIST_SERVO.setPosition(TARGET_POSITION);
        }

        @Override
        protected boolean run(RobotContext robotContext) {
            return ELAPSED_TIME.seconds() < ESTIMATED_TIME_TAKEN;
        }
    }
}