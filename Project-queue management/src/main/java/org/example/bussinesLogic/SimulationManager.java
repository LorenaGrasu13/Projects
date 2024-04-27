package org.example.bussinesLogic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.example.GUI.SimulationFrame;
import org.example.model.Server;
import org.example.model.Task;

public class SimulationManager implements Runnable {
	public int timeLimit = 100;
	public int maxProcessingTime = 10;
	public int minProcessingTime = 2;
	public int maxArrivalTime = 9;
	public int minArrivalTime = 2;
	public int numberOfServers = 3;
	public int numberOfClients = 100;
	public SelectionPolicy selectionPolicy = SelectionPolicy.SHORTEST_TIME;
	private Scheduler scheduler;
	private SimulationFrame frame;
	private List<Task> generatedTasks = new ArrayList<Task>();
	public int currentTime = 0;
	public SimulationManager(int nrClients, int nrServers, int timeLimit, int minArrivalTime, int maxArrivalTime,
			int minProcessingTime, int maxProcessingTime, SimulationFrame frame) {
		this.numberOfClients = nrClients;
		this.numberOfServers = nrServers;
		this.timeLimit = timeLimit;
		this.minArrivalTime = minArrivalTime;
		this.maxArrivalTime = maxArrivalTime;
		this.minProcessingTime = minProcessingTime;
		this.maxProcessingTime = maxProcessingTime;
		this.frame = frame;
		scheduler = new Scheduler(nrServers, nrClients + 1);
		scheduler.changeStrategy(selectionPolicy);
		this.frame.setVisible(true);
		generateNRandomTasks();
	//	Thread simulationThread = new Thread(this);
	//	simulationThread.start();
	}

	private void generateNRandomTasks() {
		int j = 0;
		for (int i = 0; i < numberOfClients; i++) {
			Random rand = new Random();
			int randomProcessingTime = rand.nextInt(maxProcessingTime - minProcessingTime + 1) + minProcessingTime;
			int randomArrivalTime = rand.nextInt(maxArrivalTime - minArrivalTime + 1) + minArrivalTime;
			Task t = new Task(i + 1, randomArrivalTime, randomProcessingTime);
			generatedTasks.add(t);
		}
		Collections.sort(generatedTasks);
	}

	@Override
	public synchronized void run() {
		PrintWriter writer;
		try {
			writer = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		int currentTime = 0;
		while (currentTime < timeLimit) {
			Iterator<Task> i = generatedTasks.iterator();
			while (i.hasNext()) {
				Task t = i.next();
				if (t.getArrivalTime() == currentTime) {
					scheduler.dispatchTask(t);
					i.remove();
				}
			}
//			if (generatedTasks.toString().equals("[]")) {
//				int ok = 1;
//				for (Server s : scheduler.getServers()) {
//					if (s.getWaitingPeriod() != 0)
//						ok = 0;
//				}
//				if (ok == 1) {
//					String t = "";
//					t = t + "Time " + currentTime + "\n";
//					t = t + "Waiting clients: " + generatedTasks + "\n";
//					for (int j = 0; j < scheduler.getServers().size(); j++) {
//						t = t + "Queue " + (j + 1) + ": ";
//						if (scheduler.getServers().get(j).getTasks().isEmpty()) {
//							t = t + "closed";
//						} else {
//							for(Task tsk: scheduler.getServers().get(j).getTasks())
//								t = t + tsk.toString();
//						}
//						t = t + "\n";
//					}
//					frame.addText(t);
//					writer.println(t);
//					break;
//				}
//			}
			String t = "";
			t = t + "Time " + currentTime + "\n";
			t = t + "Waiting clients: " + generatedTasks + "\n";
			for (int j = 0; j < scheduler.getServers().size(); j++) {
				t = t + "Queue " + (j + 1) + ": ";
				if (scheduler.getServers().get(j).getTasks().isEmpty()) {
					t = t + "closed";
				} else {
					for(Task tsk: scheduler.getServers().get(j).getTasks())
					t = t + tsk.toString();
				}
				t = t + "\n";
			}
			frame.addText(t);
			writer.println(t);
			// wait 1 sec
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			currentTime++;
		}
		writer.close();
	}

	public static void main(String[] args) {
		SimulationFrame frame = new SimulationFrame();
		frame.setVisible(true);
	}
}
