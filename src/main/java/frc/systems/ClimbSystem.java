package frc.systems;

import edu.wpi.first.wpilibj.Spark;
import frc.input.InputMethod;
import frc.robot.RobotMap;

/**
 * Controls the climb system of the robot
 */
public class ClimbSystem extends RobotSystem {
  private final double WINCH_SPEED = 0.5;
  private final double ADJUST_SPEED = 0.5;

  private Spark winchMotor;
  private Spark adjustMotor;


  /**
   * Creates a new climb system
   * 
   * @param input the controller input object
   */
  public ClimbSystem(InputMethod input) {
    super(input);
  }

  @Override
  public void init() {
    winchMotor = new Spark(RobotMap.WINCH_MOTOR);
    adjustMotor = new Spark(RobotMap.ADJUST_MOTOR);
  }

  @Override
  public void run() {
    setAdjustmentSpeed(input.shouldAdjust());
    setWinchSpeed(input.shouldWinch());
  }

  public void setAdjustmentSpeed(double speed){
    adjustMotor.setSpeed(ADJUST_SPEED * speed);
  }

  public void setWinchSpeed(double speed){
    winchMotor.setSpeed(WINCH_SPEED * speed);

  }
}