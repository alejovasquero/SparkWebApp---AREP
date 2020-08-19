package edu.escuelaing.arep;

import spark.Request;
import spark.Response;

import java.io.*;


import static spark.Spark.*;
public class SparkWebApp {
    public static void main(String[] args) {
        port(getPort());
        get("/hello", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
    }

    private static String resultsPage(Request req, Response res) {
        System.out.println(req.queryParams("text"));
        return "Hello";
    }

    public static String inputDataPage(Request req, Response res){
        StringBuilder contentBuilder = new StringBuilder();
        System.out.println(System.getProperty("user.dir"));
        try {
            BufferedReader in = new BufferedReader(new FileReader("src\\main\\webapp\\data.html"));
            String str;
            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String content = contentBuilder.toString();
        return content;
	}


    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
