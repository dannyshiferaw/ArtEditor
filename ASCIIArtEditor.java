
import java.util.LinkedList;
import java.util.List;

  /** * * * * * * * * * * * * * * * * * * * * * * * * * * **
  * This class implements an ArtEditor. It uses ArrayList  *
  * as it's underlying structure.                          *
  *                                                        *
  *       Time AND Space Complexity Analysis               *
  *        {ONLY REQUIRED OPERATIONS}                      *
  *                      
  *     -------   TIME  -------------                      *
  *        > Constructor   O(1)                            *
  *        > InsertRow     O(N)                            *
  *        > InsertCol     O(N)                            *
  *        > edit          O(N)                            *
  *    -------    SPACE -------------                      *
  *        > O(N)                                          *
  * * * * * * * * * * * * * * * * * * * * * * * * * * * * **/

  

public class ASCIIArtEditor implements ArtEditor {

    /**Stores 2D characters
     * Outer ArrayList serves as row, and inner one as column.
     */
    private List<List<Character>> board;
    private int col;

    /** Prevents clients from initializing without giving
    initial column size */
    private ASCIIArtEditor() {

    }

    /** instantiate with width*/
    public ASCIIArtEditor(int col) {
        this.board = new LinkedList<>();
        this.col = col;
    }

    /** inserts a new row at index */
    @Override
    public void insertRow(int row, char c) {
      board.add(row, new LinkedList<>());
      for(int i = 0; i < col; i++) {
          board.get(row).add(c);
      }
    }

    /** inserts a new col at index */
    @Override
    public void insertColumn(int col, char c) {
       for (int i = 0; i < Row(); i++) {
           board.get(i).add(col, c);
       }
       this.col += 1;
    }

    /** resets a character at given row and col position */
    public void edit(int row, int col, char c) {
        board.get(row).set(col, c);
    }

    /** returns a character at given row and col position */
    public Character get(int row, int col) {
        return board.get(row).get(col);
    }

    /** 2D print out of all characters */
    @Override
    public String toString() {
        StringBuilder display = new StringBuilder();
        for(int i = 0; i < Row(); i++) {
            for (int j = 0; j < Col(); j++) {
                display.append(board.get(i).get(j) + " ");
            }
            display.append(System.getProperty("line.separator"));
        }
        return display.toString();
    }

    /** returns number of rows */
    public int Row() {
        return board.size();
    }

    /** returns number of columns */
    public int Col() {
        return this.col;
    }
}
