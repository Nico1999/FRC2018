package org.usfirst.frc.team3309.robot;

import org.usfirst.frc.team3309.commands.InterruptAll;
import org.usfirst.frc.team3309.commands.subsystems.arms.ArmsClamp;
import org.usfirst.frc.team3309.commands.subsystems.arms.ArmsOpen;
import org.usfirst.frc.team3309.commands.subsystems.drive.DriveForward;
import org.usfirst.frc.team3309.commands.subsystems.drive.DriveSetHighGear;
import org.usfirst.frc.team3309.commands.subsystems.drive.DriveSetLowGear;
import org.usfirst.frc.team3309.commands.subsystems.lift.LiftShiftToClimbMode;
import org.usfirst.frc.team3309.commands.subsystems.shooter.ShooterForward;
import org.usfirst.frc.team3309.lib.input.InputXbox;
import org.usfirst.frc.team3309.lib.math.Length;

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

     //   operatorRemote.buttonA.whenPressed(new FalconDoorsDeploy());
        operatorRemote.buttonA.whenPressed(new ArmsClamp());
        operatorRemote.buttonB.whenPressed(new ArmsOpen());

        // operatorRemote.rightBumper.whenPressed(new SetClimbMode());
        operatorRemote.rightBumper.whenPressed(new LiftShiftToClimbMode());

   //     operatorRemote.leftBumper.whenPressed(new LiftSet(0.1));
    //    operatorRemote.leftBumper.whenReleased(new LiftSet(0));

        operatorRemote.leftBumper.whenPressed(new ShooterForward());

        driverRemote.buttonY.whenPressed(new DriveForward(Length.fromInches(156)));
        driverRemote.buttonA.whenPressed(new DriveForward(Length.fromInches(-156)));

    }

}
