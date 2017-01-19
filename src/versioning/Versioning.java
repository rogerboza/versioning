/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package versioning;

import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Comes from git
 * @author Roger Boza
 */
public class Versioning {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            JarFile jar = new JarFile("C:\\Users\\Roger Boza\\Documents\\NetBeansProjects\\Sonix\\dist\\Sonix.jar");
            //JarFile jar = new JarFile("https://github.com/rogerboza/hello-world/blob/master/Sonix.jar");
            
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
                        if(versionNumber.equalsIgnoreCase("1.2.2")){
                            Process proc = Runtime.getRuntime().exec("java -jar \"C:\\Users\\Roger Boza\\Documents\\NetBeansProjects\\Sonix\\dist\\Sonix.jar\"");
                            proc.waitFor();
                            // Then retreive the process output
                            InputStream in = proc.getInputStream();
                            InputStream err = proc.getErrorStream();

                            byte b[]=new byte[in.available()];
                            in.read(b,0,b.length);
                            System.out.println(new String(b));

                            byte c[]=new byte[err.available()];
                            err.read(c,0,c.length);
                            System.out.println(new String(c));
                        }
                        break;
                    }
                }
            }
            jar.close();

            System.out.println("Version: " + versionNumber); //"here it will print the version"
        } catch (IOException ex) {
            Logger.getLogger(Versioning.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Versioning.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
