package org.firstinspires.ftc.teamcode.subSystems;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.controller.PIDController;
import com.jumpypants.murphy.RobotContext;
import com.jumpypants.murphy.tasks.Task;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Zarm {
    //create slideMotor
    private final Motor slideMotor;

    //init max and min pos
    public static final double MAX_POS = 4.0;
    public static final double MIN_POS = 0.0;

    //init PID variables
    public static final double PID_P = 0.001;
    public static final double PID_I = 0.0001;
    public static final double PID_D = 0.004;

    //init slideMotorPID
    private final PIDController slideMotorPID = new PIDController(PID_P, PID_I, PID_D);

    //init slideMotor
    public Zarm(HardwareMap hardwareMap){
        slideMotor = new Motor(hardwareMap, "extensionMotor");
        slideMotor.setRunMode(Motor.RunMode.RawPower);
        slideMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        slideMotor.resetEncoder();
    }
    public class MoveVerticalMotorTask extends Task {
        private final double targetPosition;
        public MoveVerticalMotorTask(RobotContext robotContext, double targetPosition) {
            super(robotContext);
            this.targetPosition = targetPosition;
        }

        @Override
        protected void initialize(RobotContext robotContext) {
            slideMotorPID.setSetPoint(targetPosition);
        }

        @Override
        protected boolean run(RobotContext robotContext) {
            return Math.abs(slideMotor.getCurrentPosition() - targetPosition) > 10; // Tolerance of 10 ticks
        }
    }

//    public void setPos(double p){
//        slideMotorPID.setSetPoint(Math.max(MIN_POS, Math.min(MAX_POS, p)));
//    }
//
//    public void tickPID(){
//        slideMotor.set((Math.max(-1, Math.min(1, slideMotorPID.calculate(slideMotor.getCurrentPosition())))));
//    }
}
