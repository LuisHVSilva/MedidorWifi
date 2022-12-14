package LuisHVSilva.github.MedidorWifi.Configuracoes;

import LuisHVSilva.github.MedidorWifi.Constants;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.*;

public class IPAdress extends Constants {

    /*
    Map<String, String> IPMap = new HashMap<>();
    IPMap.put("/192.168.0.113", "TP-Link_C4FA_5G");
    IPMap.put("/192.168.0.114", "TP-Link_C4FA");
    IPMap.put("/192.168.1.18", "SERCOMTEL_kQ9Fb7");

    System.out.println("A rede analisada é: " + IPMap.get(ipAdress.getIp().toString()));
    */
    public InetAddress getIp() throws SocketException {

        // getNetworkInterfaces() returns a list of all interfaces present in the system.
        ArrayList<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
        Stack<InetAddress> IPList = new Stack<>();

        for (NetworkInterface iface : interfaces) {
            // isUp() method used for checking whether the interface in process is up and running or not.
            if (iface.isUp()) {
                // getInetAddresses() method returns list of all addresses currently bound to this interface
                Enumeration<InetAddress> en = iface.getInetAddresses();
                IPList.add(en.nextElement());
            }
        }

        return IPList.peek();
    }

}
