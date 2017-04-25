/**
 * This interface class serves as a base for any ASCII Art
 * Editor. It implements the following operations:
 *       > insert a row at a given index, all characters in the row set to
 *       single character
 *       > insert a column at given index, all characters in the column set to
 *       single character
 *       > set/edit a character at a specific location
 */
public interface ArtEditor {

        //insert a row at given index with all characters set to given input
        void insertRow(int col, char c);
        //insert a column at given index with all characters set to given input
        void insertColumn(int row, char c);

        //edit or reassign a character at a specific location
        void edit(int row, int column, char c);

}
