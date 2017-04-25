import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests ASCIIArtEditor Operation implementation
 */
public class TestASCIIArtEditor {

    @Test
    public void testInsertRow() {
        int row = 0;
        int col = 10;
        ASCIIArtEditor art = new ASCIIArtEditor(col);
        assertEquals(row, art.Row());
        assertEquals(col, art.Col());
        art.insertRow(row, '.');
        row += 1;
        assertEquals(row, art.Row());
        assertEquals(col, art.Col());
        for (int i = 0; i < art.Col(); i++) {
            assertEquals(new Character('.'), art.get(row - 1, i));
        }
        /** uncomment the print statement to print out */
        //art.print();
    }

    @Test
    public void testInsertColANDGet() {
        int row = 0;
        int col = 10;
        ASCIIArtEditor art = new ASCIIArtEditor(col);
        assertEquals(art.Col(), col);
        for (int i = 0; i < 7; i++, row++) {
            art.insertRow(row, '.');
        }
        assertEquals(row, art.Row());
        art.insertColumn(3, '+');
        art.insertColumn(5, '+');
        art.insertColumn(8, '+');
        col += 3;
        assertEquals(col , art.Col());
        assertEquals(new Character('+'), art.get(0, 3));
        assertEquals(new Character('+'), art.get(3, 5));
        assertEquals(new Character('+'), art.get(5, 8));
        /** uncomment the print statement to print out */
        //art.print();
    }

    @Test
    public void testEditANDGet() {
        int row = 7;
        int col = 10;
        ASCIIArtEditor art = new ASCIIArtEditor(col);
        for (int i = 0; i < row; i++) {
            art.insertRow(i, '.');
        }
        for (int i = 3; i < 7; i++) {
            art.edit(0, i, '=');
            art.edit(3, i, '=');
            art.edit(6, i, '=');
        }
        art.edit(1, 1, '/');
        art.edit(1, 2, '/');
        art.edit(2, 1, '\\');
        art.edit(2, 2, '\\');
        art.edit(4, 8, '\\');
        art.edit(4, 9, '\\');
        art.edit(5, 8, '/');
        art.edit(5, 9, '/');

        assertEquals(new Character('/'), art.get(1, 1));
        assertEquals(new Character('\\'), art.get(4, 8));
        assertEquals(new Character('\\'), art.get(2, 1));
        assertEquals(new Character('/'), art.get(5, 8));
        assertEquals(new Character('/'), art.get(5, 9));
        art.insertColumn(5, '|');
        /** uncomment the print statement to print out */
        System.out.print(art);
    }
}
