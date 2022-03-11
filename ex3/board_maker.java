package car;

public class BoardMaker {
    private final static int SIZE = 100;
    private boolean[][] board;

    /**
     * Parse the given car program and evaluate it. Render the trail as
     * described in the problem description and return a SIZExSIZE board
     * corresponding to the evaluated path.
     *
     * @param carProgram input program according to specification. may also contain invalid text!
     * @return SIZExSIZE boolean board, where true values denote "red trail".
     */
    public boolean[][] makeBoardFrom(String carProgram) throws ParserException {

        // TODO: Read text below!
        // You should handle parsing of the program in a different class.
        // That class should create and store individual programs, which
        // can then be executed.
        //
        // An example of how this method could be implemented follows.
        // Please note that this is not real Java code; you will have
        // to come up with your own classes and structures!
		/*
		// You can create a new board each time makeBoardFrom is called.


		// Create a parser that accepts a program and creates individual
		// programs.
		CommandParser parser = new CommandParser();

		// Iterate over the parsed commands and keep track of the car.
		for each parsed command {
			execute the command on the board and update the state of the car
		}
		*/

        // TODO: remove this and return a board instead
        throw new UnsupportedOperationException();
    }

    /**
     * Create a new board and return it.
     *
     * @return board, must be of size SIZExSIZE.
     */
    public boolean[][] initialBoard() {
        // TODO: remove this and return a board instead
        throw new UnsupportedOperationException();
    }
}
