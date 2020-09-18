package com.jhony.retomutante;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;



// Handler value: example.HandlerApiGateway
public class Handler implements RequestStreamHandler {
    
    
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


        String res = Persistencia.getStats(context);
        if (res == null) {
            res = "{\"message\":\"Forbidden\"";
        }
        if (outputStream != null) {
            try ( OutputStreamWriter writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
                System.out.println("res() " + res);
                writer.write(res);
            }
        }
    }

}
