package org.usfirst.frc.team3309.robot;

import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team3309.commands.subsystems.*;
import org.usfirst.frc.team3309.commands.subsystems.arms.ArmsClamp;
import org.usfirst.frc.team3309.commands.subsystems.arms.ArmsOpen;
import org.usfirst.frc.team3309.commands.subsystems.shooter.ShooterForward;
import org.usfirst.frc.team3309.lib.input.InputXbox;

/*
 * <p>Class for defining controllers
 *
 * @author Chase Blagden
 */
public class OI {

    public static InputXbox operatorRemote = new InputXbox(2);

    public static Joystick driverRemoteLeft = new Joystick(0);
    public static Joystick driverRemoteRight = new Joystick(1);

    OI() {

        operatorRemote.buttonA.whenPressed(new ArmsClamp());
        operatorRemote.buttonB.whenPressed(new ArmsOpen());

        operatorRemote.leftBumper.whenPressed(new ShooterForward());

        operatorRemote.startButton.whenPressed(new PrepareForClimb());
        operatorRemote.rightStick.whenPressed(new SetClimbMode());

        operatorRemote.buttonX.whenPressed(new IntakeCube());
        operatorRemote.buttonY.whenPressed(new MoveAssembly(AssemblyLocation.BOTTOM,true));
        operatorRemote.dPad.down.whenPressed(new MoveAssembly(AssemblyLocation.SWITCH,true));
        operatorRemote.dPad.right.whenPressed(new MoveAssembly(AssemblyLocation.SCALE_DOWN,true));
        operatorRemote.dPad.up.whenPressed(new MoveAssembly(AssemblyLocation.SCALE_MIDDLE,true));
        operatorRemote.dPad.left.whenPressed(new MoveAssembly(AssemblyLocation.SCALE_UP,true));
        operatorRemote.rightBumper.whenPressed(new MoveAssembly(AssemblyLocation.EXCHANGE_ZONE,true));

    }

}