package lib.controllers.pid;

import lib.controllers.statesandsignals.InputState;
import lib.controllers.statesandsignals.OutputSignal;

/*
 * <p>PID Controller with add-ons for velocity and acceleration
 * 
 * @author Chase Blagden
 */
public class PIDVelocityController extends PIDController {

	// constant for adjusting velocity
	private double kV;

	// constant for adjusting acceleration
	private double kA;

	// desired velocity
	private double aimVel = 0.0;

	// desired acceleration
	private double aimAcc = 0.0;

	public PIDVelocityController(double kP, double kI, double kD) {
		super(kP, kI, kD);
		this.kV = 0;
		this.kA = 0;
	}
	
	public PIDVelocityController(double kP, double kI, double kD, double kV) {
		super(kP, kI, kD);
		this.kV = kV;
		this.kA = 0;
	}

	public PIDVelocityController(double kP, double kI, double kD, double kV,
			double kA) {
		this(kP, kI, kD, kV);
		this.kA = kA;
	}

	/*
	 * @return
	 * 
	 * @param kP, kI, kD, kV, kA
	 */
	public void setConstants(double kP, double kI, double kD, double kV,
			double kA) {
		super.setConstants(kP, kI, kD);
		this.kV = kV;
		this.kA = kA;
	}

	@Override
	public OutputSignal getOutputSignal(InputState input) {
		OutputSignal signal = new OutputSignal();
		double power = super.getOutputSignal(input).getMotor() + kV * aimVel
				+ kA * aimAcc;
		signal.setMotor(power);
		return signal;
	}

}
