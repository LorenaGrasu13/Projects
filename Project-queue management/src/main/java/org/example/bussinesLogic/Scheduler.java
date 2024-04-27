package org.example.bussinesLogic;

import java.util.ArrayList;
import java.util.List;

import org.example.model.Server;
import org.example.model.Task;

public class Scheduler {
	private List<Server> servers=new ArrayList<>();
	private int maxNoServers;
	private int maxTasksPerServer;
	private Strategy strategy;

	public Scheduler(int maxNoServers, int maxTasksPerServer) {
		if (servers == null)
			servers = new ArrayList<Server>(maxNoServers);
		this.maxNoServers = maxNoServers;
		this.maxTasksPerServer = maxTasksPerServer;
		for (int i = 0; i < maxNoServers; i++) {
			Server s = new Server(maxTasksPerServer);
			s.setId(i);
			servers.add(s);
			Thread t = new Thread(s);
			t.start();
		}
	}

	public void changeStrategy(SelectionPolicy Policy) {
//apply strategy pattern to instantiate the strategy with the concrete strategy corresponding to policy
		if (Policy == SelectionPolicy.SHORTEST_QUEUE) {
			strategy = new ShortestQueueStrategy();
		}
		if (Policy == SelectionPolicy.SHORTEST_TIME) {
			strategy = new ConcreteStrategyTime();
		}
	}

	synchronized public void dispatchTask(Task t) {
//add task
		this.strategy.addTask(this.servers, t);
	}

	public List<Server> getServers() {
		return servers;
	}

	public int getMaxNoServers() {
		return maxNoServers;
	}
}
