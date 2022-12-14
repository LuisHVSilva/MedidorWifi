package LuisHVSilva.github.MedidorWifi.Velocidade;

import LuisHVSilva.github.MedidorWifi.Configuracoes.Connection;
import LuisHVSilva.github.MedidorWifi.Constants;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Download extends Constants {
    double spendTime() throws IOException {
        Connection con = new Connection();
        URL url = con.Response();

        FileOutputStream path = new FileOutputStream(FILE);
        ReadableByteChannel bytes = Channels.newChannel(url.openStream());

        double start = System.currentTimeMillis() * 0.001;
        path.getChannel().transferFrom(bytes, 0, Long.MAX_VALUE);
        double end = System.currentTimeMillis() * 0.001;

        bytes.close();
        path.close();

        return end - start;
    }
    double sizeFile(){
        double fileSize = (FILE.length() * 8) / 1000000.00;
        FILE.deleteOnExit();

        return fileSize;
    }

    public double velocity() throws IOException {
        double time = spendTime();
        double size = sizeFile();

        return size/time;
    }
}