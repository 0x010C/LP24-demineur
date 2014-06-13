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
	
	public void start() {
		if (running == false) {
			running = true;
			savedTime = 0;
			startTime = System.currentTimeMillis();
			timer = new Timer(100,this);
			timer.start();
		}
	}
	
	public void pause() {
		if (running == false) {
			running = true;
			startTime = System.currentTimeMillis(); // Time when mouse was clicked.
			timer.start();
		}
		else {
			savedTime = System.currentTimeMillis() - startTime;
			running = false;
			timer.stop();
		}
	}
	
	public void stop() {
		if(this.running == true) {
			savedTime = System.currentTimeMillis() - startTime;
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