package org.example.bussinesLogic;

import java.util.List;

import org.example.model.Server;
import org.example.model.Task;

public interface Strategy {
	public void addTask(List<Server> servers, Task t);
}
