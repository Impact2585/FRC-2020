package frc.systems;

import edu.wpi.first.wpilibj.Spark;
import frc.input.InputMethod;
import frc.robot.RobotMap;

// Controls the indexer system of the robot
public class IndexerSystem extends RobotSystem
{
    private int INDEX_SPEED = 0.8;
    private Spark index_motor;

    /**
    * Creates a new indexer system
    * 
    * @param input the controller input object
    */
    public IndexerSystem(InputMethod input)
    {
        super(input);
    }

    @Override
    public void init()
    {
        index_motor = new Spark(RobotMap.INDEX_MOTOR);
    }

    @Override
    public void run() 
    {
        index_motor.setSpeed((input.shouldShoot()) ? SHOOTER_SPEED : 0);
    }

}