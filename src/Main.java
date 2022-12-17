import LuisHVSilva.github.MedidorWifi.MapIP.IPName;
import LuisHVSilva.github.MedidorWifi.Velocidade.Download;
import LuisHVSilva.github.MedidorWifi.Velocidade.Ping;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        IPName ipName = new IPName();
        ipName.mapName();


        System.out.println("---------Teste de ping---------");
        Ping ping = new Ping();
        Map<String, Integer> ping_list = ping.pingVelocity();

        System.out.printf("Estatística do Ping: \n Enviados = %d; Recebidos = %d; Perdidos = %d\n"
                , ping_list.get("Enviados"), ping_list.get("Recebidos"), ping_list.get("Perdidos"));

        System.out.printf("""
                        Aproximar um número redondo de vezes em milissegundos:\s
                         Mínimo = %dms; Máximo = %dms; Média = %dms\s
                        """
                , ping_list.get("Mínimo"), ping_list.get("Máximo"), ping_list.get("Média"));


        System.out.println("\n---------Teste de Velocidade para Download---------");
        Download dwn = new Download();
        System.out.println("O teste de download é feito com o download de 4 imagens maiores que 40 Kbp");
        System.out.printf("Velocidade de média de download: %f\n Mbps", dwn.velocity());

    }
}