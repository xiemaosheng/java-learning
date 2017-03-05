package com.brianway.learning.java.xms.thread;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class SynchronizedObject {
    private String username = "a";
    private String password = "aa";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public synchronized void printString(String username,String password){
        try {
            this.username = username;
            Thread.sleep(20000);
            this.password = password;
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
