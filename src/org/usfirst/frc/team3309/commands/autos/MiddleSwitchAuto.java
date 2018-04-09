package org.usfirst.frc.team3309.commands.autos;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team3309.commands.WaitAndMoveAssembly;
import org.usfirst.frc.team3309.commands.subsystems.AssemblyLocation;
import org.usfirst.frc.team3309.commands.subsystems.MoveAssembly;
import org.usfirst.frc.team3309.commands.subsystems.arms.ArmsClamp;
import org.usfirst.frc.team3309.commands.subsystems.arms.ArmsOpen;
import org.usfirst.frc.team3309.commands.subsystems.drive.DriveArc;
import org.usfirst.frc.team3309.commands.subsystems.drive.DriveStraight;
import org.usfirst.frc.team3309.commands.subsystems.drive.DriveTurn;
import org.usfirst.frc.team3309.commands.subsystems.rollers.RollersActuate;
import org.usfirst.frc.team3309.commands.subsystems.rollers.RollersSetIn;
import org.usfirst.frc.team3309.lib.WaitCommand;
import org.usfirst.frc.team3309.lib.math.Length;
import org.usfirst.frc.team3309.robot.Robot;

public class MiddleSwitchAuto extends CommandGroup {

    double start;

    @Override
    public void start() {
        start = Timer.getFPGATimestamp();
        addParallel(new MoveAssembly(AssemblyLocation.BOTTOM));
        if (DriverStation.getInstance().getGameSpecificMessage().length() > 0) {

            boolean isLeftSwitch = Robot.isLeftSwitch();
            boolean isRightSwitch = Robot.isRightSwitch();

            if (isLeftSwitch) {
                addSequential(new DriveArc(Length.fromInches(13), -37, 31000, false, true)); // 16
                addParallel(new MoveAssembly(AssemblyLocation.SWITCH));
                addSequential(new DriveStraight(7.6, 25000, true, true)); // 18
                addSequential(new DriveArc(Length.fromInches(9), 16, 28000, false, true)); // 13, 20
                addSequential(new DriveStraight(25, 17000, 0)); // 17
                addSequential(new WaitCommand(0.1));
                addParallel(new ArmsOpen());
                addSequential(new RollersActuate(0.5, 0.1));

                /* second cube */
                addParallel(new WaitAndMoveAssembly(0.5, AssemblyLocation.INTAKE));
                addSequential(new DriveArc(Length.fromInches(35), 60, 26000, true, true)); // 24, 76
                addSequential(new DriveTurn(0, 1.0, true));
                addParallel(new RollersSetIn(true));
                addSequential(new DriveStraight(17, 17000, 0)); // 11
                addSequential(new ArmsClamp());

                addSequential(new WaitCommand(0.8));
                addParallel(new RollersSetIn(false));
                addParallel(new MoveAssembly(AssemblyLocation.SWITCH));
                addSequential(new DriveStraight(-10, 17000, true, true));
                addSequential(new DriveTurn(90, 1.0, true));
                addSequential(new DriveStraight(7, 26000, true, true));
                addSequential(new DriveArc(Length.fromInches(54), 78, 27000, false, true)); // 57
                addSequential(new DriveStraight(16, 12000, 0)); // 16
                addParallel(new RollersActuate(-1, 0.3));
                addSequential(new ArmsOpen());
                addSequential(new WaitCommand(0.7));

                addParallel(new MoveAssembly(AssemblyLocation.BOTTOM));
                addSequential(new DriveStraight(-17, 18000, 0));

            } else if (isRightSwitch) {
                addSequential(new DriveArc(Length.fromInches(12), 37, 31000, false, true));
                addParallel(new MoveAssembly(AssemblyLocation.SWITCH));
                addSequential(new DriveArc(Length.fromInches(12), -22, 28000, false, true));
                addSequential(new DriveStraight(4, 17000, 0));
                addSequential(new WaitCommand(0.1));
                addParallel(new ArmsOpen());
                addSequential(new RollersActuate(0.5, 0.1));

                /* second cube */
                addParallel(new WaitAndMoveAssembly(0.5, AssemblyLocation.INTAKE));
                addSequential(new DriveArc(Length.fromInches(30), -77, 26000, true, true)); // -81
                addSequential(new DriveTurn(0, 1.0, true));
                addParallel(new RollersSetIn(true));
                addSequential(new DriveStraight(21, 17000, 0));
                addSequential(new ArmsClamp());

                addSequential(new WaitCommand(0.8));
                addParallel(new RollersSetIn(false));
                addParallel(new MoveAssembly(AssemblyLocation.SWITCH));
                addSequential(new DriveStraight(-10, 17000, true, true));
                addSequential(new DriveTurn(-90, 1.0, true));
                addSequential(new DriveStraight(4, 26000, true, true));
                addSequential(new DriveArc(Length.fromInches(70), -80, 27000, false, true));
                addSequential(new DriveStraight(13, 12000, 0));
                addParallel(new RollersActuate(-1, 0.3));
                addSequential(new ArmsOpen());
                addSequential(new WaitCommand(0.7));

                addParallel(new MoveAssembly(AssemblyLocation.BOTTOM));
                addSequential(new DriveStraight(-17, 18000, 0));
            } else {
                DriverStation.reportError("Oh no! I don't know where to go! :karson5:", false);
            }
        }
        super.start();
    }

    @Override
    public void end() {
        super.end();
        System.out.println("I ended at " + (Timer.getFPGATimestamp() - start) + "!");
    }

}