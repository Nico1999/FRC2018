package org.usfirst.frc.team3309.commands.autos;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team3309.commands.subsystems.drive.DriveArc;
import org.usfirst.frc.team3309.commands.subsystems.drive.DriveStraight;
import org.usfirst.frc.team3309.commands.subsystems.drive.DriveTurn;
import org.usfirst.frc.team3309.commands.subsystems.shooter.ShooterShoot;
import org.usfirst.frc.team3309.lib.math.Length;
import org.usfirst.frc.team3309.robot.Robot;

public class SideSwitchAuto extends CommandGroup {

    private boolean onRight;

    public SideSwitchAuto(boolean onRight) {
        this.onRight = onRight;
    }

    @Override
    public void start() {
        if (onRight) {
            if (Robot.isRightSwitch()) {
                addSequential(new DriveStraight(-78, 28000, true));
                addSequential(new DriveArc(Length.fromInches(10), 50, 23000,true, true));
          /*      addSequential(new DriveTurn(90, 0.8));
                addSequential(new DriveStraight(-10, 23000, true ));*/
                addSequential(new WaitCommand(0.3));
                addSequential(new ShooterShoot());
            } else if (Robot.isLeftSwitch()) {
                addSequential(new DriveStraight(-100, DriveStraight.DriveStrategy.POSITION));
            }
        } else if (!onRight) {
            if (Robot.isRightSwitch()) {
                addSequential(new DriveStraight(139.56, DriveStraight.DriveStrategy.POSITION));
            } else if (Robot.isLeftSwitch()) {
                addSequential(new DriveStraight(-100, 25000, true));
                addSequential(new DriveArc(Length.fromInches(28), 80, 23000,false, true));
                addSequential(new WaitCommand(0.3));
                addSequential(new ShooterShoot());
            }
        }
        super.start();
    }

}