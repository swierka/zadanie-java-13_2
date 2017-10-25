package Konwerter;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Konwerter {

/*    NumberFormat nf = NumberFormat.getNumberInstance(Locale.FRANCE);
    DecimalFormat de = (DecimalFormat)nf;*/

    DecimalFormat df = new DecimalFormat("###,###,###.0");

    String MtoCM (double m){
        return df.format(m*100);
    }

    String MtoMM (double m){
        return df.format(m*1000);
    }

    String KgToG (double kg){
        return df.format(kg*1000);
    }

    String KgToMg (double kg){
        return df.format(kg*1_000_000);
    }
}
