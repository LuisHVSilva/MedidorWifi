package LuisHVSilva.github.MedidorWifi.Velocidade;

import LuisHVSilva.github.MedidorWifi.Constants;

import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;


public class Ping extends Constants {
    private final static int iteration = 4;


    public Map<String, Integer> ping_velocity() {
        int media = 0;
        int millis;

        Map<String, Integer> ping_list = new HashMap<>();
        ping_list.put("Enviados", iteration);
        ping_list.put("Recebidos", 0);
        ping_list.put("Perdidos", 0);
        ping_list.put("Mínimo", 5000);
        ping_list.put("Máximo", 0);
        ping_list.put("Média", 0);

        try {
            for (int i = 1; i <= iteration; i++) {
                InetAddress address = InetAddress.getByName(URL_PING);

                if (address.isReachable(5000)) {

                    long nanos = System.nanoTime();
                    address.isReachable(500); // this invocation is the offender

                    millis = Math.toIntExact(Math.round((System.nanoTime() - nanos) / Math.pow(10, 6)));
                    media += millis;

                    Thread.sleep(Math.max(0, 1000 - millis));

                    System.out.println("Resposta de " + address.getHostAddress() + " tempo = " + millis + "ms");

                    if (ping_list.get("Mínimo") > millis)
                        ping_list.put("Mínimo", millis);
                    if (ping_list.get("Máximo") < millis)
                        ping_list.put("Máximo", millis);

                    ping_list.put("Recebidos", (ping_list.get("Recebidos") + 1));
                } else {
                    ping_list.put("Perdidos", (ping_list.get("Perdidos") + 1));
                    media += 0;
                }
            }

            ping_list.put("Média", media/iteration);

        } catch (IOException | InterruptedException e) {
            System.out.println("Cannot lookup host " + "www.gooogle.com.br");
        }
        return (ping_list);
    }
}