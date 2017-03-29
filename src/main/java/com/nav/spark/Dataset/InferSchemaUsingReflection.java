package com.nav.spark.Dataset;

import com.nav.spark.Dataset.bean.Employee;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.List;

/**
 * Created by Neo on 3/27/2017.
 */
public class InferSchemaUsingReflection {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName(InferSchemaUsingReflection.class.getName()).setMaster("local");
        SparkSession sparkSession =SparkSession.builder().config(conf).getOrCreate();


        JavaRDD<String> empRdd = sparkSession.read().textFile("D:\\temp\\data\\input\\inputDataCSV.csv").javaRDD();

        JavaRDD<Employee> employeeJavaRDD = empRdd.map(new Function<String, Employee>() {
            @Override
            public Employee call(String v1) throws Exception {
                String[] data = v1.split(",");
                Employee emp=new Employee();
                emp.setName(data[0]);
                emp.setEmpId(Long.parseLong(data[1]));
                emp.setDept(data[2]);
                emp.setCompany(data[3]);
                return emp;
            }
        });

        List<Employee> employeeList = employeeJavaRDD.collect();
        employeeList.stream().forEach( e -> System.out.println(e));


        Dataset<Row> employeeDataset = sparkSession.createDataFrame(employeeJavaRDD,Employee.class);

        employeeDataset.show();

    }
}
