package frc.systems;

import edu.wpi.first.wpilibj.Talon;
import frc.input.InputMethod;
import frc.robot.RobotMap;

/**
 * Controls the indexer system of the robot
 */
public class IndexerSystem extends RobotSystem {
  private final double INDEX_SPEED = 0.8;

  private Talon indexer_motor;

  /**
   * Creates a new indexer system
   * 
   * @param input the controller input object
   */
  public IndexerSystem(InputMethod input) {
    super(input);
  }

  @Override
  public void init() {
    indexer_motor = new Talon(RobotMap.INDEXER_MOTOR);
  }

  @Override
  public void run() {
    setSpeed(input.shouldIndex());
  }

  public void setSpeed(double speed){
    indexer_motor.setSpeed(speed * INDEX_SPEED);
  }
}