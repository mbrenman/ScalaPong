object Pong {
	val board = new Board
	def main(args: Array[String]): Unit = {
		for (_ <- 1 to 500) {
			Thread.sleep(150)
			board.clear_screen
			board.show
		}
	}
}