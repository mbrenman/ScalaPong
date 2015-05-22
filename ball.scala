class Ball(var xPos: Int, var yPos: Int, var dx: Int, var dy: Int) {
	
	//PRNG
	val r = scala.util.Random

	def intersect(yVal: Int, xVal: Int): Boolean = {
		(xPos == xVal && yPos == yVal)
	}

	def move() {
		xPos += dx
		yPos += dy
	}

	def bounce_horiz() {
		dx = -dx
	}

	def bounce_vert() {
		dy = -dy
	}

	def reset(height: Int, width: Int) = {
		xPos = 1 + r.nextInt(width - 3)
		yPos = 1 + r.nextInt(height - 3)

		dx = if (r.nextInt(2) == 1) 1 else -1
		dy = if (r.nextInt(2) == 1) 1 else -1
	}
}