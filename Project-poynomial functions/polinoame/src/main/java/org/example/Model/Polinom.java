package org.example.Model;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {
    public String s;
    public HashMap<Integer, Double> p = new HashMap<Integer, Double>();

    public Polinom() {
    }

    public Polinom(String st) {
        this.s=st;
        String patternString ="([+-]?[0-9]\\w*[Xx^][0-9]\\w*|[+-]?[0-9]\\w*|[Xx][\\^][0-9]\\w*|[+-]?[0-9]\\w*[xX]|[+-]?[Xx])";
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(st);
        List<String> m = new ArrayList<>();
        while(matcher.find()) {
            m.add(matcher.group());
            //System.out.println(matcher.group());
        }
        for(String i: m) {
            String patternString1 = "[\\^]";
            Pattern pattern1 = Pattern.compile(patternString1, Pattern.CASE_INSENSITIVE);
            Matcher matcher1 = pattern1.matcher(i);
            String s = new String();
            while (matcher1.find()) {
                s = matcher1.group();
            }
            if (s.isEmpty()) { // nu contine ^
                String[] buffer = i.split("[xX]");
                if (buffer.length == 0) {
                    p.put(1, 1.0);
                } else {
                    Double coeficient = Double.parseDouble(buffer[0]);
                    Integer putere;
                    if(buffer[0]==i) {
                        putere = 0;
                    }
                    else{
                        putere = 1;
                    }
                    p.put(putere,coeficient);
                }
            }
            else { // contine ^
                String[] buffer = i.split("[xX][\\^]");
                Double coeficient;
                if(buffer[0].isEmpty()) {
                    coeficient = 1.0;
                }
                else{
                coeficient = Double.parseDouble(buffer[0]);}
                Integer putere = Integer.parseInt(buffer[1]);
                p.put(putere,coeficient);
                }
            }
    }

    public String afis(){
        String result="";
        for(HashMap.Entry<Integer,Double> entry: p.entrySet()){
            if(entry.getValue()>0){
                if(entry.getKey()!=0)
                {
                    result = result + " + " + entry.getValue()+"x^"+entry.getKey()+ " ";
                }
                else{
                    result = result + entry.getValue();
                }
            }
            else {
                if(entry.getKey()!=0)
                {
                    result = result + entry.getValue() + "x^" + entry.getKey()+ " ";
                }
                else {
                    result = result + entry.getValue();
                }
            }
        }
        return result;
    }
}
