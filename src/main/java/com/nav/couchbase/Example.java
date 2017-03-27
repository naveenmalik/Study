package com.nav.couchbase;

import com.couchbase.client.java.*;
import com.couchbase.client.java.cluster.BucketSettings;
import com.couchbase.client.java.cluster.ClusterManager;
import com.couchbase.client.java.document.*;
import com.couchbase.client.java.document.json.*;
import com.couchbase.client.java.query.*;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.UUID;

public class Example {

    public static void main(String... args) throws Exception {
//        // Initialize the Connection
//        //Cluster cluster = CouchbaseCluster.create("localhost");
//        Cluster cluster = CouchbaseCluster.create("localhost");
//        //ClusterManager cm = cluster.clusterManager();
//        Bucket bucket = cluster.openBucket("temp");

        //Cluster cluster = CouchbaseCluster.create("localhost");
        Cluster cluster = CouchbaseCluster.create("ec2-52-27-160-212.us-west-2.compute.amazonaws.com");
        Bucket bucket = cluster.openBucket("test");

        //bucket.remove("u:king_arthur");
        TestObject obj =new TestObject("Naveen", "123", "IT");
        // Create a JSON Document
        JsonObject arthur = JsonObject.create()
                .put("name", "Arthur")
                .put("email", "kingarthur@couchbase.com")
                .put("interests", JsonArray.from("Holy Grail", "African Swallows"));

        // Store the Document
        JsonDocument document =JsonDocument.create("u:king_arthur", arthur);
        bucket.upsert(document);

       // persist(bucket);

       //bucket.upsert(JsonDocument.create(id.toString(), JsonObject.fromJson(entity)));

        // Load the Document and print it
        // Prints Content and Metadata of the stored Document

        System.out.println(bucket.get("u:king_arthur"));

        // Create a N1QL Primary Index (but ignore if it exists)
        bucket.bucketManager().createN1qlPrimaryIndex(true, false);
        document.content().put("name", "Arthur update");
        // Perform a N1QL Query
        N1qlQueryResult result = bucket. query(
                N1qlQuery.simple("SELECT * FROM test ")
        );

        /* N1qlQuery query = N1qlQuery.parameterized("SELECT * FROM test WHERE  metaData.objectType IN [$1]",
                 JsonArray.from("project"));
        System.out.println(query.toString());
        N1qlQueryResult result = bucket.query( query);*/
        // Print each found Row
        for (N1qlQueryRow row : result) {
            // Prints {"name":"Arthur"}
            System.out.println(row);
        }

        //document.content().put("interests", "NEW");
        //bucket.replace(document);

       /* result = bucket. query(
                N1qlQuery.simple("Update test set interests=ARRAY_APPEND(interests,  'NEW')")
        );

        result = bucket. query(
                N1qlQuery.simple("SELECT * FROM test")
        );

        for (N1qlQueryRow row : result) {
            // Prints {"name":"Arthur"}
            System.out.println("replace"+row);
        }*/
       /* bucket = cluster.openBucket("beer-sample");
        bucket.bucketManager().createN1qlPrimaryIndex(true, false);

        long t1 = System.currentTimeMillis();
        query = N1qlQuery.simple("select br.name brewery, b.name beer, b.style style from `beer-sample` b \n" +
                "  join `beer-sample` br on keys b.brewery_id where br.name  = \"Yards Brewing\"  order by beer, style");
        result = bucket.query( query);
        long t2 = System.currentTimeMillis();
        for (N1qlQueryRow row : result) {
            // Prints {"name":"Arthur"}
            System.out.println(row);
        }
        long diff = t2-t1;

        System.out.println(diff);*/




    }

}