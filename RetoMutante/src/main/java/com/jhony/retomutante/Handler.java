package com.jhony.retomutante;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jhony.retomutante.tipos.JsonEntrada;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;


import org.json.JSONObject;

// Handler value: example.HandlerApiGateway
public class Handler implements RequestStreamHandler {
    
    private static final String LLAVE_JSON = "message";
    
    
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      LambdaLogger logger;
      
    /**
     *
     * @param inputStream Stream de baytes recibidos del API gateway
     * @return array de Strings en caso que exista el campo en el Json, en caso
     * contrario retorna null
     */
    private String[] validateInputApi(InputStream inputStream) {
        String[] res = null;
        if (inputStream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            try {
                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    //logger.log("paso 1 " + line);
                    sb.append(line);
                }
                line = sb.toString();
                Gson g = new Gson();
                JsonEntrada json = g.fromJson(line, JsonEntrada.class);
                String[] data = json.getDna();
                if (data != null) {
                    res = data;
                }
                
                //logger.log("linea " + line);
            } catch (Exception ex) {
                //logger.log("error entrada " + ex.getMessage());
            }
        }
        return res;
    }

    /**
     * Metodo que sirve de disparador ante eventos de llegada de API gateway de
     * AWS
     *
     * @param inputStream buffer de entrada de APIgateway
     * @param outputStream buffer de salida hacia APIgateway
     * @param context recursos adicionales del protocolo HTTP
     * @throws IOException
     */
    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {

        JSONObject response = new JSONObject();
        try {
            String[] dataInput = validateInputApi(inputStream);

            if (dataInput == null) {

                response.put(LLAVE_JSON, "Forbidden");

            } else {
                Mutante mutant = new Mutante();
                mutant.setDataArray(dataInput);
                String tipo = null;
                if (mutant.isMutant()) {
                    response.put(LLAVE_JSON, "Es un mutante");
                    tipo ="mutante";
                    
                } else {
                    response.put(LLAVE_JSON, "Forbidden");
                    tipo ="humano";;
                }
                Persistencia.save(tipo, dataInput,context);

            }
        } catch (Exception ex) {
            logger.log("error de proceso " + ex.getMessage());
        }

        if (outputStream != null) {
            try ( OutputStreamWriter writer = new OutputStreamWriter(outputStream,  StandardCharsets.UTF_8)) {
                writer.write(response.toString());
            }
        }
    }

}
