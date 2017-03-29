package com.nav.spark.Dataset;

import com.nav.spark.Dataset.bean.Employee;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Neo on 3/27/2017.
 */
public class CreatingDataSet {

    public static void main(String[] args) {

        SparkConf conf = new SparkConf().setAppName(CreatingDataSet.class.getName()).setMaster("local");
        SparkSession sparkSession = SparkSession.builder().config(conf).getOrCreate();

        Employee employee = new Employee();
        employee.setCompany("RBS");
        employee.setDept("RS");
        employee.setEmpId(new Long(7954556));
        employee.setName("Naveen");


        Encoder<Employee> employeeEncoder = Encoders.bean(Employee.class);

        Dataset<Employee> ds = sparkSession.createDataset(Collections.singletonList(employee), employeeEncoder);

        ds.show();


        Dataset<Employee> employeeDS = sparkSession.read().json("D:\\temp\\data\\input\\temp.json").as(employeeEncoder);
        employeeDS.show();

        Encoder<Integer> integerEncoder = Encoders.INT();
        Dataset<Integer> integerDS = sparkSession.createDataset(Arrays.asList(1, 2, 3, 4), integerEncoder);

        Dataset<Integer> transformedDS = integerDS.map(new MapFunction<Integer, Integer>() {
            @Override
            public Integer call(Integer value) throws Exception {
                return value * 2;
            }
        }, integerEncoder);

        //transformedDS.collect();
        transformedDS.show();

    }
}
