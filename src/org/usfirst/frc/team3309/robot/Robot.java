package org.usfirst.frc.team3309.robot;

import org.usfirst.frc.team3309.auto.AutoModeExecutor;
import org.usfirst.frc.team3309.auto.AutoRoutine;
import org.usfirst.team3309.subsystems.Drive;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import library.communications.BlackBox;

/**
 * @author Chase.Blagden
 */
public class Robot extends IterativeRobot {

	private AutoRoutine autoThread;

	@Override
	public void robotInit() {
		Systems.add(Drive.getInstance());
		Systems.init();
		BlackBox.initLog("3309" + String.valueOf(DriverStation.getInstance().getAlliance()), "X position",
				"Y position");
		AutoModeExecutor.displayAutos();
	}

	@Override
	public void autonomousInit() {
		autoThread = AutoModeExecutor.getAutoSelected();
		if (autoThread != null) {
			autoThread.startAutoThread();
		}
		Systems.initAuto();
	}

	@Override
	public void autonomousPeriodic() {
		Sensors.updateDrive();
		Systems.updateAuto();
		Systems.sendToDashboard();
		BlackBox.writeLog(String.valueOf(Drive.getInstance().getInches(Sensors.getXPos())),
				String.valueOf(Drive.getInstance().getInches(Sensors.getYPos())));
	}

	@Override
	public void teleopInit() {
		if (autoThread != null) {
			autoThread.stopAutoThread();
		}
		Systems.initTeleop();
	}

	@Override
	public void teleopPeriodic() {
		Systems.sendToDashboard();
	}

	@Override
	public void disabledPeriodic() {
		Systems.sendToDashboard();
	}
}
