package com.company.ClientServer;

import java.io.Serializable;

public class note implements Serializable {
    private String a;
    private String b;

    public note(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public int somm(){
        return  Integer.parseInt(this.a)+Integer.parseInt(this.b);
    }
}
