/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhony.retomutante;


import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.lambda.runtime.Context;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author rm
 */
public class Persistencia {

    public static String armarRespuesta(int total, int mutantecuentaM){
        String res=null;
                    if (total > 0) {
                JSONObject response = new JSONObject();
                float ratio = (float) mutantecuentaM / (float) total;
                try {
                    response.put("count_mutant_dna", mutantecuentaM);
                    response.put("count_human_dna", (total - mutantecuentaM));
                    response.put("ratio", String.format("%.2f", ratio));
                    res = response.toString();
                } catch (JSONException ex) {
                    Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        return res;
    }
    
    public static String getStats(Context context) {
        String res = null;
        int cuentaMutantes = 0;

        if (context != null) {

            AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
            ScanRequest scanRequest = new ScanRequest()
                    .withTableName("DNAMutantes");

            ScanResult result = client.scan(scanRequest);
            for (Map<String, AttributeValue> item : result.getItems()) {

                if (item.toString().contains("mutante")) {
                    cuentaMutantes++;
                }
                
            }
            res = armarRespuesta(result.getCount(),cuentaMutantes);



        }
        return res;

    }

}
