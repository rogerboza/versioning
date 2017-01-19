/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package versioning;

import java.io.IOException;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roger Boza
 */
public class Versioning {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            JarFile jar = new JarFile("C:\\Users\\Roger Boza\\Documents\\NetBeansProjects\\Sonix\\dist\\Sonix.jar");
            //System.out.println(jar.getManifest().getAttributes("Bundle-Version"));
            String versionNumber = "";
            java.util.jar.Manifest manifest = jar.getManifest();
            java.util.jar.Attributes attributes = manifest.getMainAttributes();
            if (attributes!=null){
                java.util.Iterator it = attributes.keySet().iterator();
                while (it.hasNext()){
                    java.util.jar.Attributes.Name key = (java.util.jar.Attributes.Name) it.next();
                    String keyword = key.toString();
                    System.out.println(keyword);
                    if (keyword.equals("Version")){
                        versionNumber = (String) attributes.get(key);
                        break;
                    }
                }
            }
            jar.close();

            System.out.println("Version: " + versionNumber); //"here it will print the version"
        } catch (IOException ex) {
            Logger.getLogger(Versioning.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
