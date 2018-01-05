package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Messenger {

    public static void login(String args[]) throws IOException {
        String Name;
        String port;
        String hostip;
        List<Peer> peers = new ArrayList<Peer>();

        Name = args[0];
        port = args[1];
        hostip = InetAddress.getLocalHost().toString();

        System.out.println("|-------------------------------------------------------------|");
        System.out.println("|--------Start erfolgreich. Willkommen im Einhornchat!--------|");
        System.out.println("|-------------Um den ersten Kontakt herzustellen--------------|");
        System.out.println("|--------nutze den Befehl Connect mit einer bekannten---------|");
        System.out.println("|-------------------IP/Port Adressierung.---------------------|");
        System.out.println("|--------Wenn du Hilfe benötigst, kannst du jederzeit---------|");
        System.out.println("|----------------------/help eingeben!------------------------|");
        System.out.println("|------------------------Viel Spaß!---------------------------|");
        System.out.println("|-------------------------------------------------------------|");

        //TODO: Hier Sockets zum hören einstellen!

        //TODO: Sockets zum Verbindungsaufbau pro peer in der Classe Peer (im Konstruktor sobald verbindung besteht!)

        //TODO: Die Menüführung in einen eigenen Thread einbinden!
        //TODO: Den Nachrichtenempfang in einen eigenen Thread einbinden!


        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        boolean connected = false;

        while (true) {

            String s = reader.readLine();
            String[] splitter = s.split(" ");

            {
                if (splitter[0].equals("HELP")) {

                    printhelp();
                    System.out.println("Hilfe!...Warte auf Eingabe: ");

                }

                else if (splitter[0].equals("CONNECT")) {

                    System.out.println("Verbinde:...");
                    //Poke(splitter[2], splitter[3]);
                    connected = true;
                    Socket p = new Socket();
                    peers.add(new Peer("s","1234.2","1234", p));

                }

                else if (splitter[0].equals("DISCONNECT")) {

                    if (connected) {

                        Disconnect();
                        System.out.println("Verbindung getrennt!");
                        connected = false;
                    } else {
                        System.out.println("Bitte zunächst eine Verbindung zu einem Peer aufbauen");
                    }

                }

                else if (splitter[0].equals("EXIT")) {

                    System.out.println("Verbindung getrennt!");
                    connected = false;
                    //TODO: SOCKETS ENTFERNEN!
                    // break;

                }

                else if (splitter[0].equals("M")) {

                    if (connected) {
                        sendMessage();
                        System.out.println("Nachricht gesendet");
                    }

                    else {
                        System.out.println("Bitte zunächst eine Verbindung zu einem Peer aufbauen");
                    }

                }

                else if (splitter[0].equals("MX")) {

                    if (connected) {
                        sendPrivateMessage();
                        System.out.println("Nachricht gesendet");
                    }

                    else {
                        System.out.println("Bitte zunächst eine Verbindung zu einem Peer aufbauen");
                    }

                }

                else {

                    System.out.println("Ungültige Eingabe, bitte wiederholen");
                }
            }
        }


    }

    private static void Poke(String s, String s1) {
    }

    private static void sendPrivateMessage() {
    }

    private static void sendMessage() {
    }

    private static void Disconnect() {
    }

    private static void Connect(String s, String s1) {
    }

    private static void printhelp() {
    }

}
