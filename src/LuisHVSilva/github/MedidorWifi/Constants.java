package LuisHVSilva.github.MedidorWifi;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static final File FILE = new File("C:\\temp\\arquivo-baixado.png");
    public static final String[] URL_DOWNLOAD = {
            "https://images3.alphacoders.com/857/857335.jpg",
            "https://images3.alphacoders.com/857/857335.jpg",
            "https://images3.alphacoders.com/857/857335.jpg",
            "https://images3.alphacoders.com/857/857335.jpg",
    };
    public static final int HTTPResponse = 200;
    public static final String URL_PING = "www.google.com.br";

    public static final Map<String, String> IPMap;
    static {
        IPMap = new HashMap<>();
        IPMap.put("/192.168.0.113","TP-Link_C4FA_5G");
        IPMap.put("/192.168.0.114","TP-Link_C4FA");
        IPMap.put("/192.168.1.18","SERCOMTEL_kQ9Fb7");
    }
}
