class Board {
	val height = 7
	val width  = 10

	val padLeft = new Paddle(0, height)
	val padRight = new Paddle(width - 1, height)
	val ball = new Ball(3, 3, 1, 1)

	//for paddle scanning -- test
	var padLeft_up = true
	var padRight_up = false	

	def show() {
		for (y <- 0 until height) {
			for (x <- 0 until width) {
				if (ball.intersect(y, x)) {
					print('o')
				} else if (padLeft.intersect(y, x) || padRight.intersect(y, x)) {
					print('|')
				} else {
					print('.')
				}
				print("  ")
			}
			println()
		}
		
		//bounce top/bottom walls
		if (ball.yPos == 0 || ball.yPos == height - 1) {
			ball.bounce_vert
		}

		//bounce off paddles
		if (padLeft.intersect(ball.yPos, ball.xPos) || padRight.intersect(ball.yPos, ball.xPos)) {
			ball.bounce_horiz
		}

		//out of bounds
		if (ball.xPos < 0 || ball.xPos >= width || ball.yPos < 0 || ball.yPos >= height) {
			ball.reset(height, width)
		}

		//movement
		scan_paddles
		ball.move
	}

	// for testing movement -- test
	def scan_paddles() = {
		if (padLeft_up) {
			if (!padLeft.move_up) {
				padLeft_up = false
			}
		} else {
			if (!padLeft.move_down) {
				padLeft_up = true
			}
		}

		if (padRight_up) {
			if (!padRight.move_up) {
				padRight_up = false
			}
		} else {
			if (!padRight.move_down) {
				padRight_up = true
			}
		}
	}

	def clear_screen() = {
		for (_ <- 1 to 50) {
			println()
		}
	}
}