package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

abstract class MotorDecs{
    public static DcMotor FrontLeftDrive = null;
    public static DcMotor FrontRightDrive = null;
    public static DcMotor BackLeftDrive = null;
    public static DcMotor BackRightDrive = null;

    public static void motorSetup() {
        FrontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        FrontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        BackLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        BackRightDrive.setDirection(DcMotor.Direction.FORWARD);
    }
}




// i just realized my countertop is made out of marble
// i've been taking it for granite for all these years