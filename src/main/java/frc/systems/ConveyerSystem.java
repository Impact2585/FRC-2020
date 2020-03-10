package frc.systems;

import edu.wpi.first.wpilibj.Spark;
import frc.input.InputMethod;
import frc.robot.RobotMap;

/**
 * Controls the conveyer system of the robot
 */
public class ConveyerSystem extends RobotSystem {
  private final double SPIN_SPEED = 1;

  private Spark conveyer_motor1;
  private Spark conveyer_motor2;


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
    conveyer_motor1 = new Spark(RobotMap.CONVEYER_MOTOR1);
    conveyer_motor2 = new Spark(RobotMap.CONVEYER_MOTOR2);
  }

  @Override
  public void run() {
    setSpeed(input.shouldSpinConveyer());
  }

  public void setSpeed(double speed){
    conveyer_motor1.setSpeed(SPIN_SPEED * speed);
     conveyer_motor2.setSpeed(SPIN_SPEED * speed);
  }
}