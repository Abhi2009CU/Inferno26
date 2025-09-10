package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.jumpypants.murphy.RobotContext;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
//import org.firstinspires.ftc.teamcode.subSystems.Arm;
//import org.firstinspires.ftc.teamcode.subSystems.Claw;
import org.firstinspires.ftc.teamcode.subSystems.Claw;
import org.firstinspires.ftc.teamcode.subSystems.Xarm;
import org.firstinspires.ftc.teamcode.subSystems.Zarm;

/**
 * MyRobot class that extends RobotContext to include robot-specific subsystems.
 */
public class MyRobot extends RobotContext {
    public final MecanumDrive drive;
    public final Xarm xarm;
    public final Zarm zarm;
    public final Claw claw;

    /**
     * Creates a new RobotContext with the specified telemetry and gamepad references.
     * All parameters are required and cannot be null.
     *
     * @param telemetry the telemetry instance for driver station communication
     * @param gamepad1  the primary gamepad controller
     * @param gamepad2  the secondary gamepad controller
     * @param zarm
     */
    public MyRobot(Telemetry telemetry, Gamepad gamepad1, Gamepad gamepad2, MecanumDrive drive, Xarm xarm, Zarm zarm, Claw claw) {
        super(telemetry, gamepad1, gamepad2);
        this.drive = drive;
        this.zarm = zarm;
        this.xarm = xarm;
        this.claw = claw;
    }

//    public static class EClaw {
//
//        // Mechanical components are private in their subsystem class
//        private final Servo clawServo;
//        private final Servo wristServo;
//
//        // Positions are public constants to be used by other classes as a frame of reference
//        public static final double CLAW_OPEN_POSITION = 0.0;
//        public static final double CLAW_CLOSED_POSITION = 0.7;
//        public static final double WRIST_UP_POSITION = 0.1;
//        public static final double WRIST_DOWN_POSITION = 1.0;
//
//        public EClaw(HardwareMap hardwareMap) {
//            clawServo = hardwareMap.get(Servo.class, "clawServo");
//            wristServo = hardwareMap.get(Servo.class, "wristServo");
//        }
//
//        // Tasks live inside the subsystem class
//        // Notice how they have access to the private components of the subsystem
//
//        public class MoveClawTask extends Task {
//            private final double estimatedTimeTaken;
//            private final double targetPosition;
//
//
//            public MoveClawTask(RobotContext robotContext, double targetPosition) {
//                super(robotContext);
//                double currentPosition = clawServo.getPosition();
//
//                // seconds per unit distance
//                double TIME_COEFFICIENT = 0.5;
//
//                estimatedTimeTaken = Math.abs(targetPosition - currentPosition) * TIME_COEFFICIENT;
//                clawServo.setPosition(targetPosition);
//
//                this.targetPosition = targetPosition;
//            }
//
//            @Override
//            protected void initialize(RobotContext robotContext) {
//                clawServo.setPosition(targetPosition);
//            }
//
//            @Override
//            protected boolean run(RobotContext robotContext) {
//                return ELAPSED_TIME.seconds() < estimatedTimeTaken;
//            }
//        }
//
//        public class MoveWristTask extends Task {
//            private final double estimatedTimeTaken;
//            private final double targetPosition;
//
//
//            public MoveWristTask(RobotContext robotContext, double targetPosition) {
//                super(robotContext);
//                double currentPosition = wristServo.getPosition();
//
//                // seconds per unit distance
//                double TIME_COEFFICIENT = 0.5;
//
//                estimatedTimeTaken = Math.abs(targetPosition - currentPosition) * TIME_COEFFICIENT;
//                wristServo.setPosition(targetPosition);
//
//                this.targetPosition = targetPosition;
//            }
//
//            @Override
//            protected void initialize(RobotContext robotContext) {
//                wristServo.setPosition(targetPosition);
//            }
//
//            @Override
//            protected boolean run(RobotContext robotContext) {
//                return ELAPSED_TIME.seconds() < estimatedTimeTaken;
//            }
//        }
//
//        public class ManualWristTask extends Task {
//            private final RobotContext robotContext;
//
//            public ManualWristTask(MyRobot robotContext) {
//                super(robotContext);
//                this.robotContext = robotContext;
//            }
//
//            @Override
//            protected void initialize(RobotContext robotContext) {}
//
//            @Override
//            protected boolean run(RobotContext robotContext) {
//                if (robotContext.gamepad2.dpad_up) {
//                    wristServo.setPosition(WRIST_UP_POSITION);
//                } else if (robotContext.gamepad2.dpad_down) {
//                    wristServo.setPosition(WRIST_DOWN_POSITION);
//                }
//                return true;
//            }
//        }
//    }
}
