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

public class CurvyToSwitchAuto extends CommandGroup {

    double start;

    @Override
    public void start() {
        start = Timer.getFPGATimestamp();
        addParallel(new MoveAssembly(AssemblyLocation.BOTTOM));
        if (DriverStation.getInstance().getGameSpecificMessage().length() > 0) {
            if (Robot.isLeftSwitch()) {
                addSequential(new DriveArc(Length.fromInches(16), -37, 31000, false, true));
                addParallel(new MoveAssembly(AssemblyLocation.SWITCH));
                addSequential(new DriveStraight(18, 25000, true, true));
                addSequential(new DriveArc(Length.fromInches(16), 22, 28000, false, true));
                addSequential(new DriveStraight(4, 17000, 0));
                addSequential(new WaitCommand(0.1));
                addParallel(new ArmsOpen());
                addSequential(new RollersActuate(0.5, 0.1));

                /* second cube */
                addParallel(new WaitAndMoveAssembly(0.5, AssemblyLocation.INTAKE));
                addSequential(new DriveArc(Length.fromInches(27), 76, 26000, true, true));
                addSequential(new DriveTurn(0, 1.0, true));
                addParallel(new RollersSetIn(true));
                addSequential(new DriveStraight(18, 17000, 0));
                addSequential(new ArmsClamp());

                addSequential(new WaitCommand(0.8));
                addParallel(new RollersSetIn(false));
                addParallel(new MoveAssembly(AssemblyLocation.SWITCH));
                addSequential(new DriveStraight(-10, 17000, true, true));
                addSequential(new DriveTurn(90, 1.0, true));
                addSequential(new DriveStraight(7, 26000, true, true));
                addSequential(new DriveArc(Length.fromInches(70), 78, 27000, false, true));
                addSequential(new DriveStraight(16, 12000, 0));
                addParallel(new RollersActuate(-1, 0.3));
                addSequential(new ArmsOpen());

                addSequential(new DriveStraight(-17, 18000, true, true));
                addSequential(new MoveAssembly(AssemblyLocation.BOTTOM));
            } else if (Robot.isRightSwitch()) {
                addSequential(new DriveArc(Length.fromInches(12), 37, 31000, false, true));
                addParallel(new MoveAssembly(AssemblyLocation.SWITCH));
                addSequential(new DriveArc(Length.fromInches(12), -22, 28000, false, true));
                addSequential(new DriveStraight(2, 17000, 0));
                addSequential(new WaitCommand(0.1));
                addParallel(new ArmsOpen());
                addSequential(new RollersActuate(0.5, 0.1));

                /* second cube */
                addParallel(new WaitAndMoveAssembly(0.5, AssemblyLocation.INTAKE));
                addSequential(new DriveArc(Length.fromInches(30), -81, 26000, true, true));
                addSequential(new DriveTurn(0, 1.0, true));
                addParallel(new RollersSetIn(true));
                addSequential(new DriveStraight(19, 17000, 0));
                addSequential(new ArmsClamp());

                addSequential(new WaitCommand(0.8));
                addParallel(new RollersSetIn(false));
                addParallel(new MoveAssembly(AssemblyLocation.SWITCH));
                addSequential(new DriveStraight(-10, 17000, true, true));
                addSequential(new DriveTurn(-90, 1.0, true));
                addSequential(new DriveStraight(4, 26000, true, true));
                addSequential(new DriveArc(Length.fromInches(70), -80, 27000, false, true));
                addSequential(new DriveStraight(16, 12000, 0));
                addParallel(new RollersActuate(-1, 0.3));
                addSequential(new ArmsOpen());
                addSequential(new WaitCommand(0.2));

                /* third cube */
   /*             addParallel(new WaitAndMoveAssembly(0.5, 5300, AssemblyLocation.SWITCH.getBeltBarPosition()));
                addSequential(new DriveArc(Length.fromInches(6), -20, 24000, true, true));
                addSequential(new DriveStraight(-13, 15000, true));
                addSequential(new DriveArc(Length.fromInches(10), 23, 24000, true, true));
                addParallel(new RollersSetIn(true));
                addSequential(new DriveStraight(25, 15000, 0));
                addSequential(new ArmsClamp());

                addSequential(new WaitCommand(0.7));
                addParallel(new RollersSetIn(false));
                addSequential(new DriveStraight(-10, 17000, true, true));
                addParallel(new MoveAssembly(AssemblyLocation.SWITCH));
                addSequential(new DriveTurn(-90, 1.0, true));
                addSequential(new DriveArc(Length.fromInches(45), -69, 27000, false, true));
                addSequential(new DriveStraight(10, 14000, true, true));
                addParallel(new ArmsOpen());
                addSequential(new DriveTurn(0, 1.0, true));
                addSequential(new WaitCommand(0.2));*/

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
