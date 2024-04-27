package org.example.bussinesLogic;

import java.util.List;

import org.example.model.Server;
import org.example.model.Task;

public class ConcreteStrategyTime implements Strategy {
	@Override
	public void addTask(List<Server> servers, Task t) {
		Server s = null;
		int waitingPeriodMin = Integer.MAX_VALUE;
		for (Server ser : servers) {
			int serWaitingPeriod = ser.getWaitingPeriod();
			if (serWaitingPeriod < waitingPeriodMin) {
				s = ser;
				waitingPeriodMin = serWaitingPeriod;
			}
		}
		if (s != null) {
			s.addTask(t);
		}
	}
}
