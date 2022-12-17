package LuisHVSilva.github.MedidorWifi.Velocidade;

import LuisHVSilva.github.MedidorWifi.Configuracoes.Connection;
import LuisHVSilva.github.MedidorWifi.Constants;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Download extends Constants {
    Connection con = new Connection();

    public double velocity() throws IOException {
        double vel_media = 0.0;
        int iterator = 0;

        for (String url_string: URL_DOWNLOAD) {
            URL url = con.response(url_string);
            double time = spendTime(url);
            double size = sizeFile();
            vel_media += size/time;
            iterator++;

            System.out.println("\nTeste número " + iterator);

            /*System.out.printf("Tamanho do arquivo : %.2f Megabites\n", size);
            System.out.printf("Tempo gasto para download: %.2f segundos\n", time);
            System.out.println("Velocidade do arquivo: " + size/time);
            System.out.println("Velocidade média: " + vel_media/iterator);*/
        }

        return vel_media/iterator;
    }
    double spendTime(URL url) throws IOException {

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
}