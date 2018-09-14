package org.usfirst.frc.team3309.commands.subsystems.drive;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team3309.robot.Robot;

public class DriveSetLowGear extends InstantCommand {

    public DriveSetLowGear() {
    }

    @Override
    protected void execute() {
        Robot.drive.setLowGear();
    }

}
