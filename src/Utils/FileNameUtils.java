/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author Leandro
 */
public  class FileNameUtils {
    public static String removeExtension(String fileName){
        return fileName.split("\\.")[0];
    }
    
}
