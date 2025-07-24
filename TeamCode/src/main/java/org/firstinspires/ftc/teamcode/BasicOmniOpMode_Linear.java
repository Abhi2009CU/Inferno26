

package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp(name="Basic: Omni Linear OpMode", group="Linear OpMode")

public class BasicOmniOpMode_Linear extends LinearOpMode {


    @Override
    public void runOpMode() {
        waitForStart();

        Servo servo = hardwareMap.get(Servo.class, "testServo");
        TouchSensor touchSensor = hardwareMap.get(TouchSensor.class, "touch");

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Target Servo Pos", servo.getPosition());
            telemetry.update();

            if (touchSensor.isPressed()){
                servo.setPosition(0.0);
            }else{
                servo.setPosition(1.0);
            }
        }
    }}
