package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

abstract class MotorDecs{
    public static DcMotor FrontLeftDrive = null;
    public static DcMotor FrontRightDrive = null;
    public static DcMotor BackLeftDrive = null;
    public static DcMotor BackRightDrive = null;
    public static DcMotor DualMotor1 = null;
    public static DcMotor DualMotor2 = null;
    public static DcMotor SingleMotor = null;
    public static Servo Servo1 = null;

    public static void motorSetup() {
        FrontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        FrontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        BackLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        BackRightDrive.setDirection(DcMotor.Direction.FORWARD);
        DualMotor1.setDirection(DcMotor.Direction.FORWARD);
        DualMotor2.setDirection(DcMotor.Direction.REVERSE);
        SingleMotor.setDirection(DcMotor.Direction.FORWARD);
    }
}




// i just realized my countertop is made out of marble
// i've been taking it for granite for all these years