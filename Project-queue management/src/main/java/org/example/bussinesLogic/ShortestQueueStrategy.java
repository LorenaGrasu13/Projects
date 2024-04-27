package org.example.bussinesLogic;

import java.util.List;

import org.example.model.Server;
import org.example.model.Task;

public class ShortestQueueStrategy implements Strategy {
	@Override
	public void addTask(List<Server> servers, Task t) {
		int minLine = Integer.MAX_VALUE;
		Server s = null;
		for (Server ser : servers) {
			if (ser.getSize() < minLine) {
				minLine = ser.getSize();
				s = ser;
			}
		}
		if (s != null) {
			s.addTask(t);
		}
	}
}
