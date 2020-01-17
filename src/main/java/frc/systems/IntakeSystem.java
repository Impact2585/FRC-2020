package src.main.java.frc.systems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.input.InputMethod;
import frc.robot.RobotMap;

/**
 * Controls the intake of the robot
 */
public class IntakeSystem extends RobotSystem {

  private Spark intakeMotor;

  /**
   * Creates a new IntakeSystem
   * 
   * @param input the controller input object
   */
  public IntakeSystem(InputMethod input) {
    super(input);
  }

  @Override
  public void init() {
    Spark intakeMotor = new Spark(RobotMap.intakeMotor);
  }

  @Override
  public void run() {
    if (input.intake())
    {
        intakeMotor.setSpeed(0.5);
    } else {
        intakeMotor.setSpeed(0);
    }
  }
}