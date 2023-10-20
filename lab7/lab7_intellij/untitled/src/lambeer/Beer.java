package lambeer;

import java.io.Serializable;

public class Beer implements Serializable{
    private String name;
    private String style;
    private double strength;

    public Beer(String _name, String _style, double _strength){
        name = _name;
        style = _style;
        strength = _strength;
    }

    public String getName(){
        return  name;
    }

    public String getStyle(){
        return  style;
    }

    public double getStrength() {
        return strength;
    }

    public String toString(){
        return "SÖR: " + name + " " + style + " " + strength;
    }
}
