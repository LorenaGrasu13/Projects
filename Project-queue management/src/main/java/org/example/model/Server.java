package org.example.model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {
	private BlockingQueue<Task> tasks;
	private AtomicInteger waitingPeriod;
	public int id;

	public Server() {
		tasks = new LinkedBlockingQueue<Task>();
		waitingPeriod = new AtomicInteger(0);
	}

	public Server(int noTasks) {
		tasks = new LinkedBlockingQueue<Task>();
		waitingPeriod = new AtomicInteger(0);
	}

	synchronized public void addTask(Task newTask) {
		this.tasks.add(newTask);
		waitingPeriod.addAndGet(newTask.getServiceTime());
	}

	@Override
	public void run() {
		while (true) {
				if (!tasks.isEmpty()) {
					Task t = tasks.element();
					if (t.getServiceTime() == 1)
						tasks.remove();
					t.setServiceTime(t.getServiceTime() - 1);
					waitingPeriod.getAndDecrement();
				}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	synchronized public int getSize() {
		int k = 0;
		for (Task t : tasks) {
			if (!tasks.isEmpty()) {
				k++;
			}
		}
		return k;
	}

	public BlockingQueue<Task> getTasks() {
		return tasks;
	}

	public int getWaitingPeriod() {
		return waitingPeriod.get();
	}

	public int getWaitingTime() {
		int t = this.waitingPeriod.get();
		int size = tasks.size();
		if (size == 0) {
			return 0;
		} else {
			return t / size;
		}
	}
	public int getId(){
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
