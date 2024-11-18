package br.com.alura.conversorMonetario.Conexao;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConection {


    public ExchangesRates buscaCoins(String coins) {
        String myKey = "https://v6.exchangerate-api.com/v6/34ca71c657fa64e57646bd1a/latest/" + coins;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(myKey))
                .build();

        try {
            // Envia a requisição
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Deserializa o JSON usando Gson
            String json = response.body();
            Gson gson = new Gson();
            ExchangesRates exchangesRates = gson.fromJson(json, ExchangesRates.class);
            return exchangesRates;

        } catch (IOException | InterruptedException  e ) {
            System.out.println("Erro ao obter dados da API: " + e.getMessage());
        }

        return null;
    }


}
