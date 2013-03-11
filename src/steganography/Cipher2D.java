package steganography;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Evan
 */
public class Cipher2D implements Cipher {

    private int rows, columns;
    private boolean removeSpaces = true;

    public char getSpace() {
        return ((char) ' ');
    }

    public char getRandomLetter() {
        int CHAR_BASE = 97;
        int CHAR_RANGE = 26;

        return (char) ((char) ((Math.random() * CHAR_RANGE) + CHAR_BASE));
    }

    @Override
    public String decode(String cipherText) {
        String plainText = "";
        char[][] cipher = new char[rows][columns];
        int index = 0;

        while (index <= cipherText.length()) {
            for (int column = 0; column < columns; column++) {
                for (int row = 0; row < rows; row++) {
                    cipher[row][column] = (index >= cipherText.length()) ? getSpace() : cipherText.charAt(index);
                    index++;
                }
            }
            for (int iRow = 0; iRow < cipher.length; iRow++) {
                for (int iColumn = 0; iColumn < cipher[iRow].length; iColumn++) {
//                System.out.printf("[%d, %d] = %s \n", iRow, iColumn, cipher[iRow][iColumn]);
                    plainText += cipher[iRow][iColumn];
                }
            }
        }

        return plainText;
    }

    @Override
    public String encode(String plainText) {
        String cipherText = "";
        char[][] cipher = new char[rows][columns];
//        plainText.replace('o', 'x');
        if (isRemoveSpaces()) {
            plainText = plainText.replaceAll(" ", "");
        }

        int index = 0;
        while (index <= plainText.length()) {
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    cipher[row][column] = (index >= plainText.length()) ? getRandomLetter() : plainText.charAt(index);
                    index++;
                }
            }
     
        for (int iRow = 0; iRow < cipher.length; iRow++) {
            for (int iColumn = 0; iColumn < cipher[iRow].length; iColumn++) {
                System.out.printf("[%d, %d] = %s \n", iRow, iColumn, cipher[iRow][iColumn]);
            }
        }
            for (int iColumn = 0; iColumn < cipher[0].length; iColumn++) {
                for (int iRow = 0; iRow < cipher.length; iRow++) {
                    cipherText += cipher[iRow][iColumn];
                }
            }
        }
//        take message and put it in grid
//        take the columns of grid and you have coded message.
        return cipherText;
    }

    public Cipher2D(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }
//<editor-fold defaultstate="Collapsed"> desc ="Properties"

    /**
     * @return the rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * @return the columns
     */
    public int getColumns() {
        return columns;
    }

    /**
     * @param columns the columns to set
     */
    public void setColumns(int columns) {
        this.columns = columns;
    }
//    </editor-fold>

    /**
     * @return the removeSpaces
     */
    public boolean isRemoveSpaces() {
        return removeSpaces;
    }

    /**
     * @param removeSpaces the removeSpaces to set
     */
    public void setRemoveSpaces(boolean removeSpaces) {
        this.removeSpaces = removeSpaces;
    }
}
