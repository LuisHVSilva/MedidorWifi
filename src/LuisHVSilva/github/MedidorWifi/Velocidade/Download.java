package LuisHVSilva.github.MedidorWifi.Velocidade;

import LuisHVSilva.github.MedidorWifi.Configuracoes.Connection;
import LuisHVSilva.github.MedidorWifi.Constants;
import LuisHVSilva.github.MedidorWifi.Configuracoes.Cronometro;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Download extends Constants {
    Cronometro cronometro = new Cronometro();
    Connection con = new Connection();

    private double expendTime, megaBites;

    public double getExpendTime() {
        return expendTime;
    }

    public void setExpendTime(double expendTime) {
        this.expendTime = expendTime;
    }

    public double getMegaBites() {
        return megaBites;
    }

    public void setMegaBites(double megaBites) {
        this.megaBites = megaBites;
    }

    public void teste() throws IOException {

        try {
            URL url = con.Response();

            FileOutputStream fos = new FileOutputStream(FILE);
            ReadableByteChannel rbc = Channels.newChannel(url.openStream());

            double start = cronometro.start() * 0.001;
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            double end = cronometro.end() * 0.001;

            rbc.close();
            fos.close();

            setExpendTime(end - start);
            setMegaBites((FILE.length() * 8) / 1000000.00);

            FILE.deleteOnExit(); //Deletar o arquivo baixado
        } catch (MalformedURLException e) {
            throw new MalformedURLException("ERRO: " + e);
        }
    }



}