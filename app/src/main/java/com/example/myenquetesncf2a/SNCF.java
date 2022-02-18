package com.example.myenquetesncf2a;

import java.util.HashMap;

public class SNCF {
    private static HashMap<String, Enquete> lesEnquetes = new HashMap<>();

    public static void initialiser()
    {
        if(!lesEnquetes.containsKey("rera"))
        {
            lesEnquetes.put("rera", new Enquete());
        }
        if(!lesEnquetes.containsKey("rerb"))
        {
            lesEnquetes.put("rerb", new Enquete());
        }
        if(!lesEnquetes.containsKey("rerc"))
        {
            lesEnquetes.put("rerc", new Enquete());
        }
        if(!lesEnquetes.containsKey("rerd"))
        {
            lesEnquetes.put("rerd", new Enquete());
        }
        if(!lesEnquetes.containsKey("rere"))
        {
            lesEnquetes.put("rere", new Enquete());
        }
    }

    public static Enquete getEnquete(String rer)
    {
        return lesEnquetes.get(rer);
    }
}
