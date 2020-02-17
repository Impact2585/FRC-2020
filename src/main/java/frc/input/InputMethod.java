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

  public boolean shouldIntake(){
    return false;
  }

  public boolean shouldSpinWheel(){
    return false;
  }

  public boolean shouldShoot(){
    return false;
  }

  public boolean shouldIndex(){
    return false;
  }
}