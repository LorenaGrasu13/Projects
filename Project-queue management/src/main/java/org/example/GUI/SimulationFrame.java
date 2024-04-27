package org.example.GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.example.bussinesLogic.SimulationManager;
import org.example.model.Server;

public class SimulationFrame extends JFrame {
	private JTextArea text = new JTextArea();
	private JTextField nrOfTasks = new JTextField(10);
	private JTextField nrOfServers = new JTextField(10);
	private JTextField timeLimit = new JTextField(10);
	private JTextField minArrivalTime = new JTextField(10);
	private JTextField maxArrivalTime = new JTextField(10);
	private JTextField minProcessingTime = new JTextField(10);
	private JTextField maxProcessingTime = new JTextField(10);

	public SimulationFrame() {
		text.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(text);
		getContentPane().add(scrollPane);

		JLabel nrClientsLabel = new JLabel("Number of tasks:");
		JLabel nrQueuesLabel = new JLabel("Number of servers:");
		JLabel timeLimitLabel = new JLabel("Simulation interval:");
		JLabel minArrivalTimeLabel = new JLabel("Minimum arrival time:");
		JLabel maxArrivalTimeLabel = new JLabel("Maximum arrival time:");
		JLabel minProcessingTimeLabel = new JLabel("Minimum processing time:");
		JLabel maxProcessingTimeLabel = new JLabel("Maximum processing time:");

		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(7, 2));
		inputPanel.add(nrClientsLabel);
		inputPanel.add(nrOfTasks);
		inputPanel.add(nrQueuesLabel);
		inputPanel.add(nrOfServers);
		inputPanel.add(timeLimitLabel);
		inputPanel.add(timeLimit);
		inputPanel.add(minArrivalTimeLabel);
		inputPanel.add(minArrivalTime);
		inputPanel.add(maxArrivalTimeLabel);
		inputPanel.add(maxArrivalTime);
		inputPanel.add(minProcessingTimeLabel);
		inputPanel.add(minProcessingTime);
		inputPanel.add(maxProcessingTimeLabel);
		inputPanel.add(maxProcessingTime);

		JButton startButton = new JButton("Start");
		SimulationFrame a = this;
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nrTasks = Integer.parseInt(nrOfTasks.getText());
				int nrServers = Integer.parseInt(nrOfServers.getText());
				int timeLimit = Integer.parseInt(SimulationFrame.this.timeLimit.getText());
				int minArrivalTime = Integer.parseInt(SimulationFrame.this.minArrivalTime.getText());
				int maxArrivalTime = Integer.parseInt(SimulationFrame.this.maxArrivalTime.getText());
				int minProcessingTime = Integer.parseInt(SimulationFrame.this.minProcessingTime.getText());
				int maxProcessingTime = Integer.parseInt(SimulationFrame.this.maxProcessingTime.getText());

				SimulationManager gen = new SimulationManager(nrTasks, nrServers, timeLimit, minArrivalTime,
						maxArrivalTime, minProcessingTime, maxProcessingTime, a);
                Thread t = new Thread(gen);
                t.start();
			}
		});

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(inputPanel);
		mainPanel.add(startButton);
		mainPanel.add(scrollPane);

		setTitle("Simulation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 500);
		setLocationRelativeTo(null);
		setContentPane(mainPanel);
		setVisible(true);
	}
	public void addText(String t){
		text.setText(t);
	}
}
