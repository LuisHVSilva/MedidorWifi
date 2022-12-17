package LuisHVSilva.github.MedidorWifi.Configuracoes;

import LuisHVSilva.github.MedidorWifi.Constants;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Stack;

public class IPAdress extends Constants {

    public InetAddress getIp() {
        try {
            ArrayList<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            Stack<InetAddress> IPList = new Stack<>();

            for (NetworkInterface iface : interfaces) {
                if (iface.isUp()) {
                    Enumeration<InetAddress> en = iface.getInetAddresses();
                    IPList.add(en.nextElement());
                }
            }
            return IPList.peek();

        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

}
