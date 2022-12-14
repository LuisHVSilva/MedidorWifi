import LuisHVSilva.github.MedidorWifi.MapIP.IPName;
import LuisHVSilva.github.MedidorWifi.Velocidade.Download;
import LuisHVSilva.github.MedidorWifi.Velocidade.Ping;

import java.io.IOException;
import java.util.Map;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) throws IOException {
        IPName ipName = new IPName();
        ipName.MapName();

        BiFunction<Double, Double, Double> velocityCalc = (x, y) -> x / y;


        Ping ping = new Ping();

        System.out.println("---------Teste de ping---------");
        Map<String, Integer> ping_list = ping.ping_velocity();

        System.out.printf("Estatística do Ping: \n Enviados = %d; Recebidos = %d; Perdidos = %d\n"
                , ping_list.get("Enviados"), ping_list.get("Recebidos"), ping_list.get("Perdidos"));

        System.out.printf("""
                        Aproximar um número redondo de vezes em milissegundos:\s
                         Mínimo = %dms; Máximo = %dms; Média = %dms\s
                        """
                , ping_list.get("Mínimo"), ping_list.get("Máximo"), ping_list.get("Média"));


        System.out.println("\n---------Teste de Velocidade para Download---------");
        Download download = new Download();
        download.teste();

        System.out.printf("A velocidade da rede é: %.2fMbps",
                velocityCalc.apply(download.getMegaBites(), download.getExpendTime()));
    }
}