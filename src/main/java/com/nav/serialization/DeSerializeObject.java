package com.nav.serialization;

import java.io.*;

/**
 * Created by naveen on 3/14/2016.
 */
public class DeSerializeObject {

    public static void main(String[] args) {
        String fileName = "emp.txt";

        {
            try {
                FileInputStream fileInput = new FileInputStream(fileName);
                ObjectInputStream objInput = new ObjectInputStream(fileInput);

                Employee emp = (Employee) objInput.readObject();

                System.out.println(emp);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}
