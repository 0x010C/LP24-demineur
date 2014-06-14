package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Chrono implements ActionListener {
	private long startTime;
	private long savedTime;
	private boolean running;
	private Timer timer;
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(this.getTime());
	}
	
	public Chrono(String name) {
		this.timer = new Timer(200,this);
		this.timer.setActionCommand(name);
	}
	
	public void addActionListener(ActionListener listener) {
		this.timer.addActionListener(listener);
	}
	
	public void start() {
		if (running == false) {
			running = true;
			savedTime = 0;
			startTime = System.currentTimeMillis();
			timer.start();
		}
	}
	
	public void pause() {
		if (running == false) {
			running = true;
			startTime = System.currentTimeMillis(); // Time when mouse was clicked.
			timer.restart();
		}
		else {
			savedTime += System.currentTimeMillis() - startTime;
			running = false;
			timer.stop();
			System.out.println("Saved : "+savedTime);
		}
	}
	
	public void stop() {
		if(this.running == true) {
			savedTime += System.currentTimeMillis() - startTime;
			startTime = 0;
			running = false;
			timer.stop();
		}
	}

	public int getTime() {
		return (int) (System.currentTimeMillis() - this.startTime + this.savedTime) / 1000;
	}
	public double getTimeMillis() {
		return (System.currentTimeMillis() - this.startTime + this.savedTime) / 1000;
	}
}