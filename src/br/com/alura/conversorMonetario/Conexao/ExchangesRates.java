package br.com.alura.conversorMonetario.Conexao;

import java.util.Map;

public class ExchangesRates {
    private String result;
    private String base_code;
    private Map<String, Double> conversion_rates;
    public String getResult() {
        return result;
    }

    public String getBase_code() {
        return base_code;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    @Override
    public String toString() {
        return "Resultado: " + result +
                "\nBase: " + base_code +
                "\nTaxas de conversão: " + conversion_rates;
    }
}
