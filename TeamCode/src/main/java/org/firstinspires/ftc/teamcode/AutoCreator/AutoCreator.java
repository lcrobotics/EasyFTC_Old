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
    HashMap<String, Float> newFrame;
    boolean running = false;
    // tracks the time between the last frame and this frame
    float timeElapsed = 0;
    // tracks the time on the timer of the last frame
    float lastTime = 0;

    @Override
    public void loop() {
        if (gamepad1.a) {
            running = true;
        }

        if (gamepad1.b) {
            running = false;
        }

        if (running) {
            // updates the time
            // since we only want the time between the button presses, and not since the opMode starts running,
            // we need an independent variable that changes
            timeElapsed += (time - lastTime);
            // update the frames to shift it forward
            prev = curr;
            // copy down all of the gamepad values into a new hashmap
            curr = copyCommands();
            // compare the previous frame and the current frame
            // and put all of the changes into a new hashmap
            newFrame = compareFrames(prev, curr);
            // add that hashmap into the queue
            allFrames.add(newFrame);

            // set the lastTime variable to the current time
            lastTime = (float) time;
        }
    }

    // detects the changes
    HashMap<String, Float> compareFrames(HashMap<String, Float> prev, HashMap<String, Float> curr) {
        HashMap<String, Float> changedFrame = new HashMap<String, Float>();
        for (String key : curr.keySet()) {
            if (!curr.get(key).equals(prev.get(key))) {
                changedFrame.put(key, curr.get(key));
            }
        }
        return changedFrame;
    }

    // copies all the commands that are given by the controller this frame
    // and put them into a hashmap
    // then return that hashmap
    HashMap<String, Float> copyCommands() {
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
        // track the time
        allCommands.put("time", timeElapsed);

        return allCommands;
    }
}

