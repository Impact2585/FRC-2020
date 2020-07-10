package frc.robot;

/**
 * Maps input/output pins on the RoboRIO
 */
public class RobotMap {
  //Drive motors
  public static final int LEFT_DRIVE_MOTOR = 0;
  public static final int RIGHT_DRIVE_MOTOR = 1;

  // Ball transport system motors
  public static final int INTAKE_MOTOR = 2;
  public static final int CONVEYER_MOTOR1 = 3;
  public static final int CONVEYER_MOTOR2 = 5;
  public static final int INDEXER_MOTOR = 4;

  // Climb motors
  public static final int WINCH_MOTOR = 6;
  public static final int ADJUST_MOTOR = 7;

  // Shooter motors (CAN)
  public static final int SHOOTER_MOTOR_1_CAN_ID = 0;
  public static final int SHOOTER_MOTOR_2_CAN_ID = 1;
}