/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhony.retomutante;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.lambda.runtime.Context;

/**
 *
 * @author rm
 */
public class Persistencia {

    public static int calcularLlave(String[] array) {
        String res = "";
        StringBuilder st = new StringBuilder();
        for (String data : array) {
            st.append(data);
        }
        res = st.toString();

        return res.hashCode();
    }

    public static void save(String tipoDato, String[] array, Object context) {

        if (context instanceof Context) {
            AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
            DynamoDB dynamoDB = new DynamoDB(client);
            Table table = dynamoDB.getTable("DNAMutantes");

            String hashKey = tipoDato + calcularLlave(array);

            Item item = new Item()
                    .withPrimaryKey("adnId", hashKey)
                    .withString("tipo", tipoDato)
                    .withStringSet("contenido", array);

            PutItemOutcome outcome = table.putItem(item);
            outcome.getPutItemResult().getAttributes();

        }
    }

}
