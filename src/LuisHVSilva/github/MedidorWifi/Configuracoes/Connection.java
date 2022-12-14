package LuisHVSilva.github.MedidorWifi.Configuracoes;

import LuisHVSilva.github.MedidorWifi.Constants;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Connection extends Constants {

    public URL Response(String x) throws IOException {
        try {
            URL url = new URL(x);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != HTTPResponse) //Código de sucesso de conexão = 200.
                throw new RuntimeException("HTTP error code: " + conexao.getResponseCode());

            return url;

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
