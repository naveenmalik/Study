package com.nav.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by naveen on 3/14/2016.
 */
public class SerializeObject {

    public static void main(String[] args) {

        String fileName = "emp.txt";

        Employee emp = new Employee("Naveen", "IT", "29511");

        try {
            FileOutputStream out = new FileOutputStream(fileName);
            ObjectOutputStream objOut = new ObjectOutputStream(out);

            objOut.writeObject(emp);
            objOut.flush();
            objOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
