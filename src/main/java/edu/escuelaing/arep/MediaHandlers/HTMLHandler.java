package edu.escuelaing.arep.MediaHandlers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HTMLHandler {
    private String data;
    private String file;
    private boolean opened;

    public HTMLHandler(String file){
        this.file = file;
        data = getHTML(file);
    }

    public void changeFile(String file){
        this.file = file;
        data = getHTML(file);
    }

    public void replace(String bef, String aft){
        if(data!=null){
            data = data.replaceAll(bef, aft);
        }
    }

    public String getData(){
        if(opened){
            return data;
        }
        return null;
    }

    private String getHTML(String file){
        StringBuilder contentBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;
            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String content = contentBuilder.toString();
        opened = true;
        return content;
    }

}
