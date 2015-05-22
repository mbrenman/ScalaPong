object Pong {
	val board = new Board
	def main(args: Array[String]): Unit = {
		for (_ <- 1 to 100) {
			Thread.sleep(250)
			board.clear_screen
			board.show
		}
	}
}