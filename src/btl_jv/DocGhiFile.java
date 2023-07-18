package btl_jv;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NTHT
 */
public class DocGhiFile {
    public void luuFile(String fileName, Object obj) throws Exception{
        FileOutputStream fo = new FileOutputStream(fileName);
        ObjectOutputStream oo = new ObjectOutputStream(fo);
        oo.writeObject(obj);
        oo.close();
        fo.close();
    }
    public Object docFile(String FileName) throws Exception{
        Object kq = null;
        FileInputStream fi = new FileInputStream(FileName);
        ObjectInputStream oi = new ObjectInputStream(fi);
        kq = oi.readObject();
        fi.close();
        oi.close();
        return kq;
    }
}
