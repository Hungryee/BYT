package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operation {
    public String action;
    public double left;
    public double right;

    public String getAction() {
        return action;
    }

    public double getLeft() {
        return left;
    }

    public double getRight() {
        return right;
    }

    public static String permittedOps = "[+\\-*\\/^]";
    public static String numberFormat = "\\(?\\-?\\d+\\.?\\d?\\)?";

    //SUPPORTS NEGATIVE DOUBLES TOO
    public Operation(String operation){
        try {
            Pattern p1 = Pattern.compile(numberFormat);
            Matcher m = p1.matcher(operation);
            m.find();
            this.left = Double.parseDouble(m.group(0));
            m.find();
            this.right = Double.parseDouble(m.group(0));
            Pattern p2 = Pattern.compile(permittedOps);
            Matcher m2 = p2.matcher(operation);
            m2.find();
            this.action = m2.group();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Could not match operation from the input. Calulation failed");
        }
    }


}
