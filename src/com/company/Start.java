package com.company;


import java.io.IOException;
import java.net.UnknownHostException;

import static com.company.Messenger.login;

// The start class simply checks checks the correctness of the given input values. If there are no errors, it starts the
// messenger through the login function.

public class Start {

    public static void main (String[] args)  {
            if (args.length <=1)
            {
                System.out.println("Please insert name and port you´d like to use.");
                System.out.println("-----Terminating-----");
            }
            else if(args.length >2)
            {
                System.out.println("Please insert only one name (without Backspace) and only one port you´d like to use.");
                System.out.println("-----Terminating-----");
            }
            else if(!isNumeric(args[1])|| Integer.parseInt(args[1]) <0 || Integer.parseInt(args[1]) > 65535)
            {
                System.out.println("Port has to consist of numeric digits (between 1 and 65535).");
                System.out.println("-----Terminating-----");
            }
            else if (!isAlphabetic(args[0]) || args[0].length()>16)
            {
                System.out.println("Name has to consist of up to 16 Alphabetic Letters.");
                System.out.println("-----Terminating-----");
        }

        try {
            login(args);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }
    }

    public static boolean isAlphabetic(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isNumeric(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

//
//Socket mySocket = new Socket();
//
//mySocket.connect(new InetSocketAddress("192.168.0.2",1234));
//PrintWriter p = new PrintWriter(mySocket.getOutputStream());
}