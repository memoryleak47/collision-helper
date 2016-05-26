#include "Collision.hpp"

bool Collision::inArea(int x, int y)
{
	// <changeable>
	return (x < 400 && x > 150 && y < 500 && y > 300);
	// </changeable>
}
