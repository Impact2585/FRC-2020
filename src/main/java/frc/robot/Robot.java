package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.input.XBoxInput;
import frc.systems.*;

public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  private XBoxInput input;
  private WheelSystem wheels;
  private IntakeSystem intake;
  private ConveyerSystem conveyer;
  private FlywheelSystem flywheel;
  private IndexerSystem indexer;
  private ClimbSystem climb;

  private Timer autonTimer;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    input = new XBoxInput();
    wheels = new WheelSystem(input);
    wheels.init();
    intake = new IntakeSystem(input);
    intake.init();
    indexer = new IndexerSystem(input);
    indexer.init();
    conveyer = new ConveyerSystem(input);
    conveyer.init();
    flywheel = new FlywheelSystem(input);
    flywheel.init();
    climb = new ClimbSystem(input);
    climb.init();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    /*m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);*/
    autonTimer = new Timer();
    autonTimer.start();
  }

  /**
   * This function is called periodically during autonomous.
   * TO-DO: Tune motor speeds and time values.
   */
  @Override
  public void autonomousPeriodic() {
    if(autonTimer.get() < 4){
      flywheel.setSpeed(0.75);
      // Wait for shooter to spin up
    } else if (autonTimer.get() < 8){
      // Run rollers to shoot
      intake.setSpeed(1);
      conveyer.setSpeed(1);
      indexer.setSpeed(1);
    } else if (autonTimer.get() < 8.5){
      // Stop rollers
      intake.setSpeed(0);
      conveyer.setSpeed(0);
      indexer.setSpeed(0);
      flywheel.setSpeed(0);
    } else if (autonTimer.get() < 12){
      // Drive backward to cross initiation line
      wheels.drive(-0.5, -0.5);
    } else {
      // Stop
      wheels.drive(0, 0);
    }

    // TO-DO : different autons for different positions
    /*switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }*/

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    wheels.run();
    intake.run();
    conveyer.run();
    flywheel.run();
    indexer.run();
    climb.run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    wheels.run();
    intake.run();
    conveyer.run();
    flywheel.run();
    indexer.run();
    climb.run();
  }
}
