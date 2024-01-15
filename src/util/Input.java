package util;

import java.util.Scanner;

public class Input {
    private static final Scanner scanStr = new Scanner(System.in);
    private static final Scanner scanInt = new Scanner(System.in);

    public static String str(String msg){
        System.out.print(msg);
        return scanStr.nextLine();
    }
    public static int num(String msg){
        System.out.print(msg);
        if (scanInt.hasNextInt()){
            return scanInt.nextInt();
        }
        else {
            return num(msg);
        }
    }
}
