/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_jv;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Thuy
 */
public class DBEngine {
    public void luuFile(String fileName, Object obj) throws Exception{
        FileOutputStream fs = new FileOutputStream(fileName);
        ObjectOutputStream os = new ObjectOutputStream(fs);
        os.writeObject(obj);
        os.close();
        fs.close();
    }
    public Object docFile(String fileName)throws Exception{
        Object kq = null;
        FileInputStream fi = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fi);
        kq = ois.readObject();
        fi.close();
        ois.close();
        return kq;
    }
}