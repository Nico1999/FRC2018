package lib.controllers.pid;

public class PIDConstants {

    private double pScale;
    private double iScale;
    private double dScale;
    private double integralLimit;

    public PIDConstants() {}

    public PIDConstants(double p, double i, double d) {
        this.pScale = p;
        this.iScale = i;
        this.dScale = d;
    }

    public PIDConstants(double p, double i, double d, double integralLimit) {
        this(p, i, d);
        this.integralLimit = integralLimit;
    }

    public double getP() {
        return pScale;
    }

    public double getI() {
        return iScale;
    }

    public double getD() {
        return dScale;
    }

    public double getIntegralLimit() {
        return integralLimit;
    }
}
