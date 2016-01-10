package main;

import java.util.Timer;
import java.util.TimerTask;
import java.util.LinkedList;
import java.util.HashMap;

import collision.CollisionHelper;
import collision.Collision;

public class Main
{
	public static final int FRAME_INTERVAL = 40; // intervall in dem tick() und render() ausgeführt werden
	public static final int TILESIZE = 40;

	public static final float DRAG_X = 1.9f;
	public static final float DRAG_Y = 1.06f;
	public static final float GRAVITY = 0.04f;
	public static final float STANDART_JUMPPOWER = 0.7f;
	public static final float STANDART_ACCELERATION = 0.18f;

	public static LinkedList<CollisionHelper> helpers = new LinkedList<CollisionHelper>();

	public void tick()
	{
		for (int x = 0; x < Screen.WIDTH; x++)
			for (int y = 0; y < Screen.HEIGHT; y++)
				if (Collision.inArea(x, y))
					helpers.add(new CollisionHelper(x, y));
	}


	public static void main(String args[])
	{
		new Main().run(); // neue Main-instanz erstellen und deren run funktion ausführen
	}

	private void run()
	{
		init(); // initalisieren

		new Timer().scheduleAtFixedRate(new TimerTask() // wiederhole alle <FRAME_INTERVAL> ms
		{
			@Override
			public void run()
			{
				tick(); // tick
				render(); // render
			}
		}, FRAME_INTERVAL, FRAME_INTERVAL);
	}

	private void init()
	{
		Screen.init(); // init Screen
	}

	private void render()
	{
		Screen.render(); // rendere die menuList auf den 'Screen
	}
}
