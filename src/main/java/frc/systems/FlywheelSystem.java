package frc.systems;

import frc.input.InputMethod;
import frc.robot.RobotMap;

import com.revrobotics.CANError;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * Controls the flywheel system of the robot
 */
public class FlywheelSystem extends RobotSystem {
  private final double SHOOTER_SPEED = 1;

  private CANSparkMax shooter_motor1;
  private CANSparkMax shooter_motor2;

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
    shooter_motor1 = new CANSparkMax(RobotMap.SHOOTER_MOTOR_1_CAN_ID, MotorType.kBrushless);
    shooter_motor2 = new CANSparkMax(RobotMap.SHOOTER_MOTOR_2_CAN_ID, MotorType.kBrushless);

    shooter_motor1.setIdleMode(IdleMode.kCoast);
    shooter_motor2.setIdleMode(IdleMode.kCoast);

    shooter_motor1.setOpenLoopRampRate(3);
    shooter_motor2.setOpenLoopRampRate(3);

    shooter_motor1.setInverted(true);
    shooter_motor2.setInverted(false);
  }

  @Override
  public void run() {
    if(input.shouldShoot()){
      setSpeed(SHOOTER_SPEED);
    } else {
      setSpeed(0);
    }
  }

  public void setSpeed(double speed){
    shooter_motor1.set(speed);
    shooter_motor2.set(speed);
  }
}