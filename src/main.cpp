#include <SFML/Graphics.hpp>
#include "Collision.hpp"

int main()
{
	const int WIDTH = 800;
	const int HEIGHT = 600;

	sf::RenderWindow window(sf::VideoMode(WIDTH, HEIGHT), "Collision Tester");
	sf::Image image;
	image.create(WIDTH, HEIGHT);
	for (int x = 0; x < WIDTH; x++)
		for (int y = 0; y < WIDTH; y++)
		{
			if (Collision::inArea(x, y))
			{
				image.setPixel(x, y, sf::Color::Red);
			}
		}

	sf::Texture texture;
	texture.loadFromImage(image);

	sf::Sprite sprite(texture);
	window.draw(sprite);
	window.display();
	while (window.isOpen())
	{
		sf::Event ev;
		window.pollEvent(ev);
		if (ev.type == sf::Event::Closed)
		{
			// window.close();
		}
	}
	return 0;
}
