package com.company;

import java.net.Socket;
import java.util.List;

public class Peer {

    private String Name;
    private String ip;
    private String port;
    private Socket peersocket;

    public Peer(String name, String ip, String port, Socket peersocket) {
        Name = name;
        this.ip = ip;
        this.port = port;
        this.peersocket = peersocket;
    }

    public Socket getPeersocket() {
        return peersocket;
    }

    public void setPeersocket(Socket peersocket) {
        this.peersocket = peersocket;
    }


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }


}
