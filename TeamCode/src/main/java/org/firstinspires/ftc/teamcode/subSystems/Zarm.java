package org.firstinspires.ftc.teamcode.subSystems;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.controller.PIDController;
import com.jumpypants.murphy.RobotContext;
import com.jumpypants.murphy.tasks.Task;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Zarm {

    private final Motor SLIDE_MOTOR;

    public static final double MAX_POS = 4.0;
    public static final double MIN_POS = 0.0;

    public static final double PID_P = 0.001;
    public static final double PID_I = 0.0001;
    public static final double PID_D = 0.004;

    private final PIDController SLIDE_MOTOR_PID = new PIDController(PID_P, PID_I, PID_D);

    public Zarm(HardwareMap hardwareMap){
        SLIDE_MOTOR = new Motor(hardwareMap, "shoulderMotor");
        SLIDE_MOTOR.setRunMode(Motor.RunMode.PositionControl);
        SLIDE_MOTOR.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        SLIDE_MOTOR.resetEncoder();
    }
    public class MoveVerticalMotorTask extends Task {
        private final double TARGET_POSITION;

        public MoveVerticalMotorTask(RobotContext robotContext, double targetPosition) {
            super(robotContext);
            this.TARGET_POSITION = targetPosition;
        }

        @Override
        protected void initialize(RobotContext robotContext) {
            SLIDE_MOTOR_PID.setSetPoint(TARGET_POSITION);
        }

        @Override
        protected boolean run(RobotContext robotContext) {
            return Math.abs(SLIDE_MOTOR.getCurrentPosition() - TARGET_POSITION) < 5;
        }
    }
}

