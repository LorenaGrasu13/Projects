package org.example.Logic;

import org.example.Model.Polinom;

public class Operatii {

    public Polinom result=new Polinom();
    public static final String INITIAL_VALUE = "0";
    public Operatii(){

    }
    public static Polinom adunare(Polinom p1, Polinom p2) {
        Polinom result = new Polinom();
        for(Integer i: p1.p.keySet()) {
            result.p.put(i,p1.p.get(i));
        }
        for(Integer i: p2.p.keySet()) {
            if(result.p.get(i)==null)
            {
                result.p.put(i,p2.p.get(i));
            }
            else {
                result.p.put(i, result.p.get(i) + p2.p.get(i));
            }
        }
        return result;
    }

    public static Polinom scadere(Polinom p1, Polinom p2) {
        Polinom result = new Polinom();
        for(Integer i: p1.p.keySet()) {
            result.p.put(i,p1.p.get(i));
        }
        for(Integer i: p2.p.keySet()) {
            if(result.p.get(i)==null)
            {
                result.p.put(i,-1*p2.p.get(i));
            }
            else {
                result.p.put(i, result.p.get(i) - p2.p.get(i));
            }
        }
        return result;
    }
    public static Polinom inmultire(Polinom p1, Polinom p2) {
        Polinom result = new Polinom();
        for(Integer i: p1.p.keySet()) {
            for(Integer j: p2.p.keySet()) {
                if(result.p.get(i+j)!=null) {
                    result.p.put(i + j, result.p.get(i + j) + p1.p.get(i) * p2.p.get(j));
                }
                else{
                    result.p.put(i+j,p1.p.get(i) * p2.p.get(j));
                }
            }
        }
        return result;
    }
    public static Polinom derivare(Polinom p1) {
        Polinom result = new Polinom();
        for(Integer i: p1.p.keySet()) {
            if (i != 0) {
                result.p.put(i-1, p1.p.get(i)*i);
            }
            else result.p.put(0,p1.p.get(i)*i);
        }
        return result;
    }

    public static Polinom integrare(Polinom p1) {
        Polinom result = new Polinom();
        for(Integer i: p1.p.keySet()) {
            result.p.put(i + 1, p1.p.get(i) / (i + 1));
        }
        return result;
    }
    public void setResult(Polinom result) {
        this.result = result;
    }
    public String getResult() {
        return result.s;
    }
    public void reset(){
        this.result = new Polinom(INITIAL_VALUE);
    }
}
