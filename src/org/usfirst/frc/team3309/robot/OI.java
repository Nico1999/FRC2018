package org.usfirst.frc.team3309.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3309.commands.subsystems.*;
import org.usfirst.frc.team3309.commands.subsystems.arms.ArmsClamp;
import org.usfirst.frc.team3309.commands.subsystems.arms.ArmsOpen;
import org.usfirst.frc.team3309.commands.subsystems.beltbar.BeltBarMoveToPos;
import org.usfirst.frc.team3309.commands.subsystems.drive.DriveSetHighGear;
import org.usfirst.frc.team3309.commands.subsystems.drive.DriveSetLowGear;
import org.usfirst.frc.team3309.commands.subsystems.lift.LiftSetHolderIn;
import org.usfirst.frc.team3309.commands.subsystems.lift.LiftSetHolderOut;
import org.usfirst.frc.team3309.commands.subsystems.lift.LiftShiftToClimbMode;
import org.usfirst.frc.team3309.commands.subsystems.shooter.ShooterForward;
import org.usfirst.frc.team3309.lib.input.InputXbox;

/*
 * <p>Class for defining controllers
 *
 * @author Chase Blagden
 */
public class OI {

    public static InputXbox driverRemote = new InputXbox(0);
    public static InputXbox operatorRemote = new InputXbox(1);


    OI() {

        driverRemote.leftBumper.whenPressed(new DriveSetLowGear());
        driverRemote.leftBumper.whenReleased(new DriveSetHighGear());

        driverRemote.backButton.whenPressed(new InterruptAll());
        operatorRemote.backButton.whenPressed(new InterruptAll());

        operatorRemote.buttonA.whenPressed(new ArmsClamp());
        operatorRemote.buttonB.whenPressed(new ArmsOpen());

        operatorRemote.leftBumper.whenPressed(new ShooterForward());

        operatorRemote.startButton.whenPressed(new PrepareForClimb());
        operatorRemote.backButton.whenReleased(new SetClimbMode());

        operatorRemote.buttonX.whenPressed(new IntakeCube());
        operatorRemote.buttonY.whenPressed(new MoveAssembly(AssemblyLocation.BOTTOM));
        operatorRemote.dPad.down.whenPressed(new MoveAssembly(AssemblyLocation.SWITCH));
        operatorRemote.dPad.right.whenPressed(new MoveAssembly(AssemblyLocation.SCALE_DOWN));
        operatorRemote.dPad.up.whenPressed(new MoveAssembly(AssemblyLocation.SCALE_MIDDLE));
        operatorRemote.dPad.left.whenPressed(new MoveAssembly(AssemblyLocation.SCALE_UP));
        operatorRemote.rightBumper.whenReleased(new MoveAssembly(AssemblyLocation.EXCHANGE_ZONE));
    }

}

