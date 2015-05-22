class Paddle(val xPos: Int, val boardHeight: Int) {
	val length = 2;
	var top = 1;

	def intersect(yVal: Int, xVal: Int): Boolean = {
		return (yVal >= top) &&
				(yVal < top + length) &&
				(xVal == xPos)
	}

	def move_down(): Boolean = {
		if (top + length < boardHeight) {
			top += 1
			true
		} else {
			false
		}
	}

	def move_up(): Boolean = {
		if (top > 0) {
			top -= 1
			true
		} else {
			false
		}
	}
}