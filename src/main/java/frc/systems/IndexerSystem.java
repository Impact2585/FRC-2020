package frc.systems;

import edu.wpi.first.wpilibj.Spark;
import frc.input.InputMethod;
import frc.robot.RobotMap;

/**
 * Controls the indexer system of the robot
 */
public class IndexerSystem extends RobotSystem {
  private final double INDEX_SPEED = 0.;

  private Spark indexer_motor;

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
    indexer_motor = new Spark(RobotMap.INDEXER_MOTOR);
  }

  @Override
  public void run() {
    indexer_motor.setSpeed(input.shouldIndex() * INDEX_SPEED);
  }
}