import br.com.alura.conversorMonetario.Conexao.ApiConection;
import br.com.alura.conversorMonetario.Conexao.ExchangesRates;
import br.com.alura.conversorMonetario.Modelagem.Coins;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        Coins.mostrarMoedas();
        String moedasDisponiveis = """
                No momento temos essas moedas Disponíveis, adicionaremos mais no brevemente:
                ARS - Peso argentino
                BOB - Boliviano boliviano
                BRL - Real brasileiro
                CLP - Peso chileno
                COP - Peso colombiano
                USD - Dólar americano
                """;
        System.out.println(moedasDisponiveis);

        while (loop)
        {

            // Solicita a moeda base do usuário
            System.out.println("Qual sua moeda: (ARS, USD, COP, CLP, BRL, BOB)");
            String moedaInicial = sc.nextLine().toUpperCase();

            if (!Coins.isMoedaValida(moedaInicial)){
                System.out.println("Moeda inválida! Tente novamente");
                continue;
            }

            ApiConection apiConection = new ApiConection();
            ExchangesRates exchangesRates = apiConection.buscaCoins(moedaInicial);

            // Verifica se a API retornou um resultado válido
            if (exchangesRates != null)
            {

                System.out.println("Base: "
                        + exchangesRates.getBase_code());

                // Solicita a moeda para conversão
                System.out.print("Para qual moeda você quer converter: (ARS, USD, COP, CLP, BRL, BOB) ");
                String moedaConversao = sc.nextLine().toUpperCase();

                // Verifica se a moeda de conversão é válida
                if (!Coins.isMoedaValida(moedaConversao)) {
                    System.out.println("Moeda de conversão inválida!");
                    continue;
                }

                // Verifica se a moeda de conversão existe no mapa de taxas
                if (exchangesRates.getConversion_rates().containsKey(moedaConversao))
                {

                    double rate = exchangesRates.getConversion_rates().get(moedaConversao);
                    System.out.println("Taxa de conversão de "
                            + moedaInicial +
                            " para "
                            + moedaConversao +
                            ": " +
                            rate);

                    // Solicita o valor a ser convertido
                    System.out.print("Digite o valor que deseja converter: ");
                    if (sc.hasNextDouble())
                    {

                        double valor = sc.nextDouble();
                        sc.nextLine();

                        double valorConvertido = valor * rate;
                        System.out.printf("%.2f %s em %s é: %.2f %n",
                                valor,
                                moedaInicial,
                                moedaConversao,
                                valorConvertido);

                    }else {
                        System.out.println("Entrada inválida! Certifique-se de digitar um número.");
                        sc.nextLine(); // Limpa o buffer caso a entrada seja inválida
                    }


                } else {
                    System.out.println("Moeda de conversão inválida!");
                }

            }else {
                System.out.println("Erro ao obter taxas de câmbio. Verifique a moeda original.");
            }

            // Verifica se o usuário deseja continuar
            System.out.print("Deseja realizar outra conversão? (s/n): ");
            String condicaoSaida = sc.nextLine().toLowerCase();
            loop = condicaoSaida.equals("s");
        }

        System.out.println("Programa finalizado!");
        sc.close();
    }
}