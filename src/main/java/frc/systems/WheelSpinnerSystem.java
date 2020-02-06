package frc.systems;

import edu.wpi.first.wpilibj.Spark;
import frc.input.InputMethod;
import frc.robot.RobotMap;

/**
 * Controls the wheel spinner system of the robot
 */
public class WheelSpinnerSystem extends RobotSystem {
  private final double SPIN_SPEED = 0.5;

  private Spark spinner_motor;

  /**
   * Creates a new wheel spinner system
   * 
   * @param input the controller input object
   */
  public WheelSpinnerSystem(InputMethod input) {
    super(input);
  }

  @Override
  public void init() {
    spinner_motor = new Spark(RobotMap.SPIN_MOTOR);
  }

  @Override
  public void run() {
    spinner_motor.setSpeed((input.shouldSpinWheel()) ? SPIN_SPEED : 0);
  }
}