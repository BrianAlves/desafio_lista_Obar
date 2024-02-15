import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Contribuinte.TaxPlayer;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            List<TaxPlayer> taxPlayers = new ArrayList<>();

            System.out.print("Quantos contribuintes você vai digitar? ");
            final int N = sc.nextInt();

            for (int i = 0; i < N; i++) {
                System.out.println();
                System.out.printf("Digite os dados do %do contribuinte:%n", (i + 1));
                System.out.print("Renda anual com salário: ");
                final double RENDA_ANUAL = sc.nextDouble();
                System.out.print("Renda anual com prestação de serviço: ");
                final double RENDA_ANUAL_PREST_SERVICO = sc.nextDouble();
                System.out.print("Renda anual com ganho de capital: ");
                final double RENDA_ANUAL_CAPITAL = sc.nextDouble();
                System.out.print("Gastos médicos: ");
                final double GASTO_MEDICO = sc.nextDouble();
                System.out.print("Gastos educacionais: ");
                final double GASTO_EDUCACIONAL = sc.nextDouble();

                taxPlayers.add(new TaxPlayer(
                        RENDA_ANUAL, RENDA_ANUAL_PREST_SERVICO, RENDA_ANUAL_CAPITAL, GASTO_MEDICO, GASTO_EDUCACIONAL));
            }

            sc.close();

            for (int i = 0; i < taxPlayers.size(); i++) {
                System.out.println();
                System.out.printf("Resumo do %do contribuinte:%n", (i + 1));
                System.out.printf("Imposto bruto total: %.2f%n", taxPlayers.get(i).grossTax());
                System.out.printf("Abatimento: %.2f%n", taxPlayers.get(i).netTax());
                System.out.printf("Imposto devido: %.2f%n", taxPlayers.get(i).taxRebate());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}