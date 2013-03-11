/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package steganography;

/**
 *
 * @author Evan
 */
public interface Cipher {
    
    public String decode(String cipherText);
    public String encode(String plainText);
    
}
