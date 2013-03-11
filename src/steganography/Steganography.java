/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package steganography;

/**
 *
 * @author Evan
 */
public class Steganography {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        testEncode();
    }

    private static void testEncode() {
        Cipher2D c2d = new Cipher2D(6,5);
        String input = c2d.encode("two can keep a secret if one is dead");
        System.out.println(input);
        String output = c2d.decode(input);
        System.out.println(output);
    }
}
