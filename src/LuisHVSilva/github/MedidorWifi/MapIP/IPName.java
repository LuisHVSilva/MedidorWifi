/*
    Classe para dizer qual
 */
package LuisHVSilva.github.MedidorWifi.MapIP;

import LuisHVSilva.github.MedidorWifi.Configuracoes.IPAdress;
import LuisHVSilva.github.MedidorWifi.Constants;

public class IPName extends Constants {
    IPAdress ip = new IPAdress();
    public void mapName() {
        if (!IPMap.containsKey(ip.getIp().toString()))
            System.out.println("-----------------------------------------------------\n" +
                    "A rede analisada é desconhecida com IP: " + (ip.getIp().toString()) +
                    "\n-----------------------------------------------------\n");
        else {
            System.out.println("-----------------------------------------------------\n" +
                    "A rede analisada é: " + IPMap.get(ip.getIp().toString()) +
                    "\n-----------------------------------------------------\n");
        }
    }
}
