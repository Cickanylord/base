package hu.bme.mit.train.system;

import java.util.TimerTask;

import hu.bme.mit.train.interfaces.TrainController;

public class RunTrain extends TimerTask{
	public TrainController controller;
	public void run(){
		controller.followSpeed();
	}
}