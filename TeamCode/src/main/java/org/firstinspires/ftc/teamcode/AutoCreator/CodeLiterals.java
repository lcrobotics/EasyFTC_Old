package org.firstinspires.ftc.teamcode.AutoCreator;

public class CodeLiterals {
    String drive = "public static void drive(double x, double y, double w) {\n" +
            "        FrontLeftDrive.setPower(y - x + w);\n" +
            "        FrontRightDrive.setPower(y + x - w);\n" +
            "        BackLeftDrive.setPower(y + x + w);\n" +
            "        BackRightDrive.setPower(y - x - w);\n" +
            "    }";

    String dualMotor = "public static void dualMotor(double val1, double val2) {\n" +
            "        DualMotor1.setPower(val1);\n" +
            "        DualMotor2.setPower(val2);\n" +
            "    }";

    String singleMotor = "public static void singleMotor(double val1) {\n" +
            "        SingleMotor.setPower(val1);\n" +
            "    }";

    String servo = " public static void servo(double position) {\n" +
            "        Servo1.setPosition(position);\n" +
            "    }";
}
