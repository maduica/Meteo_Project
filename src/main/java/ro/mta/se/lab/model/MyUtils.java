package ro.mta.se.lab.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

/**
 * @author Duica Marius
 * aceasta clasa reprezinta un set de instrumente(functii ce sunt
 * predispuse la a fi folosite de mai multe ori pe parcursul programului)
 */
public class MyUtils {

    public MyUtils()
    {

    }
    public int checkExist_(Vector<String> words, String forSearch) {

        int ok = 0;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equals(forSearch)) {
                ok++;
                break;
            }
        }
        return ok;
    }
    public String returnCurrentDate_()
    {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
    }

    public void markToFile(String date,String country,String city ,String action,String wind,String pressure,String temperature) throws IOException {
        FileWriter f=new FileWriter("history.txt",true);
        PrintWriter printer_=new PrintWriter(f);
        printer_.println(date+" "+country+city+"\n"+action+" "+temperature+"\u00B0"+"C\n"+pressure+"atm, wind:"+wind+"mph"+"\n");
        printer_.close();
    }



}
