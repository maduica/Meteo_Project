package ro.mta.se.lab.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

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
}
