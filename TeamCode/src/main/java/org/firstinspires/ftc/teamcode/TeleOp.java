package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.SuperOp.*;

class TeleOp {
    // speed modifiers - change if necessary to modify robot speed
    // the variables in the array are in the order:
    // {x, y, w}
    // where x is strafing, y is forward-backward, and w is rotation
    // private since another variable in Autonomous has the same name

    // since the values from the gamepads are always -1 to 1, but the robot might not need to move
    // at full speed, a speed modifier is necessary
    private static double[] speed_modifiers = {0.75, 0.75, 0.75};

    // takes in controller values from SuperOp in the controller_vals array,
    // modify the array using the speed_modifiers array, and
    // calls the drive method with the modified speed values
    static void speed_drive(double[] controller_vals) {
        for (int i = 0; i < 2; i++){
            controller_vals[i] = controller_vals[i] * speed_modifiers[i];
        }
        drive(controller_vals);
    }
}




// a long long time ago two brothers insisted it was possible to fly
// and turns out, they were Wright