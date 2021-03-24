package edu.escuelaing.arep.app;

import spark.Request;
import spark.Response;
import static spark.Spark.*;

import com.google.gson.Gson;


public class SparkServer {


    private static Calculator calculator = new CalculatorServices();
    private static Gson gson = new Gson();

    public static void main(String ... args){
        port(getPort());
        get("/hello", (req,res) -> "Hello!" );
        get("/sen", SparkServer::getSen);
        get("/tan",SparkServer::getTan);

    }

    private static Object getSen(Request request, Response response) {
        Double value = Double.valueOf(request.queryParams("value"));
        Double answer = calculator.calculateSen(value);
        Json json = new Json("sen", value, answer);
        return gson.toJson(json);
    }

    private static Object getTan(Request request, Response response) {
        Double value = Double.valueOf(request.queryParams("value"));
        Double answer = calculator.calculateTan(value);
        Json json = new Json("tan", value, answer);
        return gson.toJson(json);
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}