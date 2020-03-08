package frc.systems;

import edu.wpi.first.wpilibj.Spark;
import frc.input.InputMethod;
import frc.robot.RobotMap;

/**
 * Controls the conveyer system of the robot
 */
public class ConveyerSystem extends RobotSystem {
  private final double SPIN_SPEED = 1;

  private Spark conveyer_motor;

  /**
   * Creates a new conveyer system
   * 
   * @param input the controller input object
   */
  public ConveyerSystem(InputMethod input) {
    super(input);
  }

  @Override
  public void init() {
    conveyer_motor = new Spark(RobotMap.CONVEYER_MOTORS);
  }

  @Override
  public void run() {
    setSpeed(input.shouldSpinConveyer());
  }

  public void setSpeed(double speed){
    conveyer_motor.setSpeed(SPIN_SPEED * speed);
  }
}