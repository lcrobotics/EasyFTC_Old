package org.firstinspires.ftc.teamcode.AutoCreator;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import org.firstinspires.ftc.teamcode.SuperOp;

public class AutoCreator extends SuperOp {
    Queue<HashMap<String, Float>> allFrames = new LinkedList<>();
    HashMap<String, Float> prev;
    HashMap<String, Float> curr;

    @Override
    public void loop() {
        // update the frames to shift it forward
        prev = curr;
        HashMap<String, Float> curr = createFrame();
    }

    HashMap<String, Float> compareFrames(HashMap<String, Float> prev, HashMap<String, Float> curr) {
        for (String i : curr.keySet()) {
            if (curr.get(i).equals(prev.get(i))) {

            }
        }
        return
    }

    HashMap<String, Float> createFrame() {
        HashMap<String, Float> allCommands = new HashMap<String, Float>();

        // put all of the values into the hashmap
        allCommands.put("left_stick_x", gamepad1.left_stick_x);
        allCommands.put("left_stick_y", gamepad1.left_stick_y);
        allCommands.put("right_stick_x", gamepad1.right_stick_x);
        allCommands.put("right_stick_y", gamepad1.right_stick_y);
        allCommands.put("left_trigger", gamepad1.left_trigger);
        allCommands.put("right_trigger", gamepad1.right_trigger);
        /* change variable types - since the gamepad values are returned as booleans
           and the hashmap is string and float, we have to manually change the type
           from boolean to float
           also because we can use a float to represent a boolean,
           but not a boolean to represent a float
        */
        allCommands.put("dpad_up",(gamepad1.dpad_up) ? 1.0f : 0.0f);
        allCommands.put("dpad_down",(gamepad1.dpad_down) ? 1.0f : 0.0f);
        allCommands.put("dpad_left",(gamepad1.dpad_left) ? 1.0f : 0.0f);
        allCommands.put("dpad_right",(gamepad1.dpad_right) ? 1.0f : 0.0f);
        allCommands.put("a", (gamepad1.a) ? 1.0f : 0.0f);
        allCommands.put("b", (gamepad1.b) ? 1.0f : 0.0f);
        allCommands.put("x", (gamepad1.x) ? 1.0f : 0.0f);
        allCommands.put("y", (gamepad1.y) ? 1.0f : 0.0f);
        allCommands.put("start", (gamepad1.start) ? 1.0f : 0.0f);
        allCommands.put("back", (gamepad1.back) ? 1.0f : 0.0f);
        allCommands.put("left_bumper", (gamepad1.left_bumper) ? 1.0f : 0.0f);
        allCommands.put("right_bumper", (gamepad1.right_bumper) ? 1.0f : 0.0f);
        allCommands.put("left_stick_button", (gamepad1.left_stick_button) ? 1.0f : 0.0f);
        allCommands.put("right_stick_button", (gamepad1.right_stick_button) ? 1.0f: 0.0f);

        return allCommands;
    }

    /**
     * write object that tracks the changes in every gamepad value and stores them in the queue
     * every runtime loop the object will take all the gamepad values
     * and stores them into a queue
     *
     * should be dome with a hashmap or linkedlist or array or objects
     * that stores name of the controller button and the value
     *
     *
     */


}

