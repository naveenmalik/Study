package com.nav.test;

import org.apache.log4j.Logger;

/**
 * Simple example of overriding clone() method in Java to understand How Cloning of
 * Object works in Java.
 *
 * @author
 */
public class JavaCloneTest {
    private static final Logger logger = Logger.getLogger(JavaCloneTest.class);

    public static void main(String args[]) {

        Rectangle rec1 = new Rectangle(10,20, null);
        Rectangle rec = new Rectangle(30, 60, rec1);
        logger.info(rec);

        Rectangle copy = null;
        try {
            logger.info("Creating Copy of this object using Clone method");
            copy = rec.clone();
            logger.info("Copy " + copy);

        } catch (CloneNotSupportedException ex) {
            logger.debug("Cloning is not supported for this object");
        }

        //testing properties of object returned by clone method in Java
        logger.info("copy != rec : " + (copy != rec));
        logger.info("copy.getClass() == rec.getClass() : " + (copy.getClass() == rec.getClass()));
        logger.info("copy.equals(rec) : " + copy.equals(rec));

        //Updating fields in original object
        rec.setHeight(100);
        rec.setWidth(45);

        rec.getRec().setHeight(100);
        rec.getRec().setWidth(200);

        logger.info("Original object :" + rec);
        logger.info("Clonned object  :" + copy);
    }

}

