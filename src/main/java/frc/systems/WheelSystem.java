package frc.systems;

import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.input.InputMethod;
import frc.robot.RobotMap;

/**
 * Controls the drivetrain of the robot
 */
public class WheelSystem extends RobotSystem {
  private final double DRIVE_AMT = 1;

  private DifferentialDrive wheels;

  /**
   * Creates a new wheelSystem
   * 
   * @param input the controller input object
   */
  public WheelSystem(InputMethod input) {
    super(input);
  }

  @Override
  public void init() {
    Spark leftMotor = new Spark(RobotMap.LEFT_DRIVE_MOTOR);
    Spark rightMotor = new Spark(RobotMap.RIGHT_DRIVE_MOTOR);
    wheels = new DifferentialDrive(leftMotor, rightMotor);
  }

  @Override
  public void run() {
    double[] power = new double[]{input.leftSidePower() * DRIVE_AMT, input.rightSidePower() * DRIVE_AMT};
    wheels.tankDrive(power[0], power[1], true);
  }
  
  public double[] pointToTape(){
        Target t = getLoc();
        double Kp = -0.03; //TUNE
        double min_command = 0.05; //TUNE
        double error = -t.x;
        double adjust = 0.0;
        if(t.x > 0.5){
            adjust = Kp*error*error - min_command;
        }
        else if(t.x < 0.5){
            adjust = Kp*error*error + min_command;
        }
        SmartDashboard.putString("TARGET DEBUG",t.toString());
        return new double[]{adjust,-adjust};
    }
    public Target getLoc(){
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight-impact");
        NetworkTableEntry tx = table.getEntry("tx");
        NetworkTableEntry ty = table.getEntry("ty");
        NetworkTableEntry ta = table.getEntry("ta");
        double x = tx.getDouble(0.0);
        double y = ty.getDouble(0.0);
        double a = ta.getDouble(0.0);
        Target t = new Target(x,y,a);
        SmartDashboard.putNumber("target", tx.getDouble(0.0));
        return t;
    }
    public double getTargetDistance(){
        Target t = getLoc();
        double mountingAngle = 25.0; // TUNE
        double targetAngle = t.y;
        double mountHeight = 15;
        double targetHeight = 60;
        double d = (targetHeight-mountHeight)/Math.tan(mountingAngle+targetAngle);
        return d;
    }
    public double[] driveToTarget(){
        double dist = getTargetDistance();
        double target1 = 50;
        double target2 = 10;
        if(dist < 40){
            return new double[]{(target2-dist)/10,(target2-dist)/10};
        }
        else {
            return new double[]{(target1-dist)/10,(target1-dist)/10};
        }
    }
    public void target(){
        double[] turn = pointToTape();
        double[] forward = driveToTarget();
        wheels.tankDrive(turn[0]+forward[0], turn[1]+forward[1]);
    }
    static class Target {
        double x, y;
        double area;

        public Target(double x, double y, double area) {
            this.x = x;
            this.y = y;
            this.area = area;
        }

        public String toString() {
            return "x: " + x + " y: " + y + "area: " + area;
        }
    }
}
