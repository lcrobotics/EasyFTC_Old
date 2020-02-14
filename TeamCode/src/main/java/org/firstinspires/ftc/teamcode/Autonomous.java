package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.SuperOp.drive;

class Autonomous {
    // speed modifiers - refer to TeleOp to see how they work
    // the desired speed during auto might be different from the desired speed during TeleOp,
    // so two different variables
    /**
     * possibly redundant, as the speed modifiers can be applied directly into the values
     * passed into the method
     */
    private static double[] speed_modifiers = {0.75, 0.75, 0.75};

    // whenever the robot needs to be driven in auto, call this function and pass in
    // a double array with all the speed values
    static void auto_drive(double[] speed_vals) {
        for (int i = 0; i < 2; i++){
            speed_vals[i] = speed_vals[i] * speed_modifiers[i];
        }
        drive(speed_vals);
    }

    /**
     * Vision and AccelDrive can be static subclasses of this class
     * so they can be referenced from SuperOp and anything that extends SuperOp
     */
}
