package org.firstinspires.ftc.teamcode;

// bunch of import stuff
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import static org.firstinspires.ftc.teamcode.MotorDecs.*;
import static org.firstinspires.ftc.teamcode.TeleOp.*;

/**
 * All of the other classes (MotorDecs, Autonomous, TeleOp) are just meant to store methods
 * for their respective purpose (declaring motors, storing autonomous methods, storing TeleOp methods)
 *
 * They shouldn't be run directly as the Autonomous program or TeleOp program, as there are
 * non-static fields in SuperOp that the Autonomous and TeleOp class can't access
 * such as gamepad values and the hardwaremap object for setting up motors
 * The Autonomous and TeleOp class are only here to offload some methods from SuperOp
 * and make SuperOp cleaner
 *
 * To create an actual Autonomous or TeleOp program, extend SuperOp so it can access everything
 * that SuperOp can access (the Autonomous and TeleOp methods in the Autonomous and TeleOp classes)
 */

public abstract class SuperOp extends OpMode {
    // controller speed variables
    // since gamepads are not static, the controller speeds can't be static so have to be stored
    // in SuperOp
    public double controller_x_speed = gamepad1.left_stick_x;
    public double controller_y_speed = gamepad1.left_stick_y;
    public double controller_w_speed = gamepad1.right_stick_x;

    public double x_speed_mod = .7;

    @Override
    public void init() {
        // since hardwareMap is non-static, we can't reference it from a static method in MotorDecs
        // so all motor initializations have to be here
        FrontLeftDrive = hardwareMap.get(DcMotor.class, "FrontLeftDrive");
        FrontRightDrive = hardwareMap.get(DcMotor.class, "FrontRightDrive");
        BackLeftDrive = hardwareMap.get(DcMotor.class, "BackLeftDrive");
        BackRightDrive = hardwareMap.get(DcMotor.class, "BackRightDrive");

        DualMotor1 = hardwareMap.get(DcMotor.class, "DualMotor1");
        DualMotor2 = hardwareMap.get(DcMotor.class, "DualMotor2");

        SingleMotor = hardwareMap.get(DcMotor.class, "SingleMotor");

        Servo1 = hardwareMap.get(Servo.class, "Servo1");

        // set up the motors
        motorSetup();
    }

    @Override
    public void loop(){
        controller_x_speed = gamepad1.left_stick_x;
        controller_y_speed = gamepad1.left_stick_y;
        controller_w_speed = gamepad1.right_stick_x;
    }


    // takes all controller values and shove them out to TeleOp to be speed-modified
    public void c_drive() {
        double x = (controller_x_speed > 0.05 || controller_x_speed < -0.05) ? controller_x_speed : 0;
        double y = (controller_y_speed > 0.05 || controller_y_speed < -0.05) ? controller_y_speed : 0;
        double w = (controller_w_speed > 0.05 || controller_w_speed < -0.05) ? controller_w_speed : 0;
        double[] motor_speeds = {x, y, w};
        speed_drive(motor_speeds);
    }

    // all different types of drive methods will pass values into this method
    // all the values passed into here will be modified already, so
    // this method only has to set the motor power according to the speeds
    // this is the only method that sets the power to the wheels
    public static void drive_array(double[] motor_speeds) {
        FrontLeftDrive.setPower(motor_speeds[1] - motor_speeds[0] + motor_speeds[2]);
        FrontRightDrive.setPower(motor_speeds[1] + motor_speeds[0] - motor_speeds[2]);
        BackLeftDrive.setPower(motor_speeds[1] + motor_speeds[0] + motor_speeds[2]);
        BackRightDrive.setPower(motor_speeds[1] - motor_speeds[0] - motor_speeds[2]);
    }

    public static void drive(double x, double y, double w) {
        FrontLeftDrive.setPower(y - x + w);
        FrontRightDrive.setPower(y + x - w);
        BackLeftDrive.setPower(y + x + w);
        BackRightDrive.setPower(y - x - w);
    }

    public static void dualMotor(double val1, double val2) {
        DualMotor1.setPower(val1);
        DualMotor2.setPower(val2);
    }

    public static void singleMotor(double val1) {
        SingleMotor.setPower(val1);
    }

    public static void servo(double position) {
        Servo1.setPosition(position);
    }
}



// where do pirates get their hooks?
// from the second hand store