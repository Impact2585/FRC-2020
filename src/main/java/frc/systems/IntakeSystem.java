package frc.systems;

import edu.wpi.first.wpilibj.Spark;
import frc.input.InputMethod;
import frc.robot.RobotMap;

/**
 * Controls the intake system of the robot
 */
public class IntakeSystem extends RobotSystem {
  private final double INTAKE_SPEED = 0.8;

  private Spark intake_motor;

  /**
   * Creates a new intake system
   * 
   * @param input the controller input object
   */
  public IntakeSystem(InputMethod input) {
    super(input);
  }

  @Override
  public void init() {
    intake_motor = new Spark(RobotMap.INTAKE_MOTOR);
  }

  @Override
  public void run() {
    setSpeed(input.shouldIntake());
  }

  public void setSpeed(double speed){
    intake_motor.setSpeed(speed * INTAKE_SPEED);
  }
}