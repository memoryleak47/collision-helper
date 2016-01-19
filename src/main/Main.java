package main;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.awt.Color;
import java.awt.Point;

import collision.Collision;

public class Main extends Canvas
{
	public static final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(); // bildschirmbreite
	public static final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight(); // bildschirmhöhe

	private static JFrame frame; // fenster

	// ausgeführt von Main.init()
	public static void main(String[] args)
	{
		new Main().render();
	}

	private Main()
	{
		frame = new JFrame("Collision Helper"); // erstellung des fensters
		frame.add(this); // diese Screen instanz zum fenster hinzufügen
		frame.setSize(WIDTH, HEIGHT); // größe des fensters auf die größe des bildschirms setzen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // -> fenster schließt, wenn man auf das kreuz drückt
		frame.setVisible(true); // -> fenster ist sichtbar
		frame.setResizable(true); // -> fenstergröße ist variabel (fullscreen ist möglich)
		frame.setFocusable(true); // -> man kann das fenster focusen, listeners können nur funktionieren wenn das fenster gefocust ist
		requestFocusInWindow();  // das fenster wird fokusiert
	}

	// called by Main.render() in a fixed rate
	public void render()
	{
		Graphics g = getGraphics();
		g.setColor(Color.BLACK); // setze farbe auf schwarz
		g.fillRect(0, 0, WIDTH, HEIGHT); // fülle den bildschirm schwarz
		g.setColor(Color.RED); // setze farbe auf schwarz
		for (int x = 0; x < WIDTH; x++)
		{
			for (int y = 0; y < HEIGHT; y++)
			{
				if (Collision.inArea(x, y))
				{
					g.fillRect(x, y, 1, 1);
				}
			}
		}
		g.dispose(); // dispose die graphics
	}
}
