package hu.bme.mit.train.system;

import java.util.Timer;
import java.util.TimerTask;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.user.TrainUserImpl;

public class TrainSystem {

	private TrainController controller = new TrainControllerImpl();
	private TrainUser user = new TrainUserImpl(controller);
	private TrainSensor sensor = new TrainSensorImpl(controller, user);
	private Timer t = new Timer();
	private RunTrain task;

	TrainSystem(){
		task = new RunTrain();
		task.controller = this.controller;
		t.schedule(task, 1000);
	}

	public TrainSystem(){
		RunnableImpl r = new RunnableImpl(controller);
		Thread t1 = new Thread(r);
		t1.start();
	}
	
	public TrainController getController() {
		return controller;
	}

	public TrainSensor getSensor() {
		return sensor;
	}

	public TrainUser getUser() {
		return user;
	}

}
