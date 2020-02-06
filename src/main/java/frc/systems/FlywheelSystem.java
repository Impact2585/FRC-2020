package frc.systems;

import edu.wpi.first.wpilibj.Spark;
import frc.input.InputMethod;
import frc.robot.RobotMap;

/**
 * Controls the flywheel system of the robot
 */
public class FlywheelSystem extends RobotSystem {
  private final double SHOOTER_SPEED = 0.8;

  private Spark shooter_motor;

  /**
   * Creates a new flywheel system
   * 
   * @param input the controller input object
   */
  public FlywheelSystem(InputMethod input) {
    super(input);
  }

  @Override
  public void init() {
    shooter_motor = new Spark(RobotMap.SHOOTER_MOTOR);
  }

  @Override
  public void run() {
    shooter_motor.setSpeed((input.shouldShoot()) ? SHOOTER_SPEED : 0);
  }
}