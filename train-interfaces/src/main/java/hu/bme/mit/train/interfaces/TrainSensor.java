package hu.bme.mit.train.interfaces;

public interface TrainSensor {

	int getSpeedLimit();

	boolean overrideSpeedLimit(int speedLimit);

}
