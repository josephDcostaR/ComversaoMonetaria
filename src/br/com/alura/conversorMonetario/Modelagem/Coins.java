package br.com.alura.conversorMonetario.Modelagem;

import java.util.Set;

public class Coins{
        private static  final Set<String> MOEDAS_SUPORTADAS =Set.of(
                "ARS", // Peso argentino
                "BOB", // Boliviano
                "BRL", // Real brasileiro
                "CLP", // Peso chileno
                "COP", // Peso colombiano
                "USD"  // Dólar americano

        );

        // Método para verificar se a moeda é suportada
        public static  boolean isMoedaValida(String moeda) {
            return MOEDAS_SUPORTADAS.contains(moeda);
        }

        // Método para exibir as moedas suportadas
        public static  void mostrarMoedas() {
            System.out.println("Moedas suportadas: " + MOEDAS_SUPORTADAS);
        }


}
