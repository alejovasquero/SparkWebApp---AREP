package edu.escuelaing.arep;

import edu.escuelaing.arep.MediaHandlers.HTMLHandler;
import edu.escuelaing.arep.Statistics.StatisticsPackage;
import edu.escuelaing.arep.collections.LinkedList;
import spark.Request;
import spark.Response;

import javax.swing.text.html.HTML;
import java.io.*;


import static spark.Spark.*;
public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        get("/hello", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
    }

    private static String resultsPage(Request req, Response res) {
        String a = req.queryParams("text");
        String lines[] = a.split("\\r?\\n");
        LinkedList<Double> l = new LinkedList<Double>();
        for(String s : lines){
            try{
                l.add(Double.parseDouble(s));
            } catch (NumberFormatException e){
                //:(
            }
        }
        HTMLHandler handler = new HTMLHandler("src/main/webapp/data.html");
        handler.replace("mean", Double.toString(StatisticsPackage.calculateMean(l)));
        handler.replace("deviation", Double.toString(StatisticsPackage.calculateDeviation(l)));
        return handler.getData();
    }

    public static String inputDataPage(Request req, Response res) throws Exception {
        HTMLHandler handler = new HTMLHandler("src/main/webapp/data.html");
        return handler.getData();
	}



    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
