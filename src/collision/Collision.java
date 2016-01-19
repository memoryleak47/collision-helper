package collision;

// The only file you should change for testing purposes

public class Collision
{
	public static boolean inArea(int x, int y)
	{
		// Collision is defined in here
		return (x < 400 && x > 150 && y < 500 && y > 300);
	}

}
