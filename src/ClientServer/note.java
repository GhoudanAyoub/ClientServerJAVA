package ClientServer;

import java.io.Serializable;

/**
 * GHOUDAN Ayoub
 * **/
public class note implements Serializable {
    private int a;
    private int b;

    public note(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int somm(){
        return  this.a+this.b;
    }
}
