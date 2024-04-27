package org.example.model;

public class Task implements Comparable {
	private int ID;
	private int arrivalTime;
	private int serviceTime;

	public Task(int ID, int a, int s) {
		this.ID = ID;
		this.arrivalTime = a;
		this.serviceTime = s;
	}

	public int getArrivalTime() {
		return this.arrivalTime;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public int getID() {
		return ID;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String toString() {
		return "(" + ID + " , " + arrivalTime + " , " + serviceTime + ")";
	}

	@Override
	public int compareTo(Object o) {
		Task t = (Task) o;
		return this.arrivalTime - t.arrivalTime;
	}
}
