package LuisHVSilva.github.MedidorWifi.MapIP;

import LuisHVSilva.github.MedidorWifi.Configuracoes.IPAdress;

import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class IPName extends IPAdress {

    public void MapName() throws SocketException {
        Map<String, String> IPMap = new HashMap<>();
        IPMap.put("/192.168.0.113", "TP-Link_C4FA_5G");
        IPMap.put("/192.168.0.114", "TP-Link_C4FA");
        IPMap.put("/192.168.1.18", "SERCOMTEL_kQ9Fb7");
        if (!IPMap.containsKey(getIp().toString()))
            IPMap.put("Rede desconhecida", getIp().toString());

        System.out.println("-----------------------------------------------------\n" +
                "A rede analisada é: " + IPMap.get(getIp().toString()) +
                "\n-----------------------------------------------------\n");
    }

}
