package com.nav.spark.Dataset;

import com.google.common.collect.Lists;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import java.util.List;

/**
 * Created by Neo on 3/27/2017.
 */
public class CreateSchemaProgrammatically {

    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName(CreateSchemaProgrammatically.class.getName()).setMaster("local");
        SparkSession sparkSession= SparkSession.builder().config(conf).getOrCreate();

        String schemaString = "Name,EmpId,Dept,Company";

        List<StructField> structFieldList = Lists.newArrayList();
        for(String fieldName : schemaString.split(",")){
            StructField field = DataTypes.createStructField(fieldName, DataTypes.StringType, true);
            structFieldList.add(field);
        }

        StructType schema = DataTypes.createStructType(structFieldList);

        JavaRDD<String> employeeRDD = sparkSession.read().textFile("D:\\temp\\data\\input\\inputDataCSV.csv").toJavaRDD();

        JavaRDD<Row> rowRDD = employeeRDD.map(new Function<String, Row>() {
            @Override
            public Row call(String v1) throws Exception {
                String[] row = v1.split(",");
                return RowFactory.create(row[0],row[1],row[2],row[3]);
            }
        });

        Dataset<Row> employeeDS = sparkSession.createDataFrame(rowRDD,schema);

        employeeDS.createOrReplaceTempView("employee");

        Dataset<Row> result = sparkSession.sql("select * from employee");

        result.show();

    }
}
