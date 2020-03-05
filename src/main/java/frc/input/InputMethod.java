package frc.input;

/**
 * Operator controls for the robot
 */
public abstract class InputMethod {
  public double leftSidePower() {
    return 0;
  }

  public double rightSidePower() {
    return 0;
  }

  public int shouldIntake(){
    return 0;
  }

  public int shouldSpinConveyer(){
    return 0;
  }

  public boolean shouldShoot(){
    return false;
  }

  public int shouldIndex(){
    return 0;
  }
}