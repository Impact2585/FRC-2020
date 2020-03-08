package frc.input;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * The input from the XBox remote
 */
public class XBoxInput extends InputMethod {
  private XboxController controller;
  private final double JOYSTICK_DEAD_ZONE = 0.075;
  private boolean shouldShoot;

  public XBoxInput() {
    // the joystick is registered as port #0
    controller = new XboxController(0);
    shouldShoot = false;
  }

  @Override
  public double leftSidePower() {
    double forward = controller.getY(Hand.kLeft);
    if(Math.abs(forward) < JOYSTICK_DEAD_ZONE)
      return 0;
    return forward;
  }

  @Override
  public double rightSidePower() {
    double forward = controller.getY(Hand.kRight);
    if(Math.abs(forward) < JOYSTICK_DEAD_ZONE)
      return 0;
    return forward;
  }

  @Override
  public double shouldIntake(){
    if(controller.getBumper(Hand.kLeft) || controller.getTriggerAxis(Hand.kLeft) > 0.75)
      return 1;
    return 0;
  }

  @Override
  public double shouldIndex(){
    if(controller.getBumper(Hand.kLeft))
      return 1;
    if(controller.getBumper(Hand.kRight))
      return -0.5;
    return 0;
  }

  @Override
  public double shouldSpinConveyer(){
    if(controller.getBumper(Hand.kLeft))
      return 1;
    if(controller.getTriggerAxis(Hand.kLeft) > 0.75)
      return 0.2;
    if(controller.getBumper(Hand.kRight))
      return -0.5;
    return 0;
  }

  @Override
  public boolean shouldShoot(){
    if(controller.getBumper(Hand.kRight)){
      shouldShoot = true;
    }
    if(controller.getTriggerAxis(Hand.kRight) > 0.75){
      shouldShoot = false;
    }
    return shouldShoot;
  }
}