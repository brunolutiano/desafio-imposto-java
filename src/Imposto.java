import java.util.Locale;
import java.util.Scanner;

public class Imposto {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double salario, servico, capital, medico, educacao,
                impsalario, impservico, impcapital, impbruto, maxded,
                gastosded, totalded, impdevido;

        System.out.print("Renda anual com salário: ");
        salario = sc.nextDouble();

        if (salario / 12 <= 3000) {
            impsalario = 0;
        } else {
            if ((salario / 12 > 3000 && salario / 12 <= 5000)) {
                impsalario = salario * 0.1;
            } else {
                impsalario = salario * 0.2;
            }
        }

        System.out.print("Renda anual com prestação de serviço: ");
        servico = sc.nextDouble();

        if (servico > 0) {
            impservico = servico * 0.15;
        } else {
            impservico = 0;
        }

        System.out.print("Renda anual com ganho de capital: ");
        capital = sc.nextDouble();

        if (capital > 0) {
            impcapital = capital * 0.2;
        } else {
            impcapital = 0;
        }

        impbruto = impsalario + impservico + impcapital;

        System.out.print("Gastos médicos: ");
        medico = sc.nextDouble();

        System.out.print("Gastos educacionais: ");
        educacao = sc.nextDouble();

        gastosded = medico + educacao;
        maxded = impbruto * 0.3;
        totalded = 0;

        if (gastosded > maxded) {
            totalded = maxded;
        } else {
            totalded = gastosded;
        }

        impdevido = impbruto - totalded;

        System.out.println("RELATÓRIO DE IMPOSTO DE RENDA");
        System.out.println("CONSOLIDADO DE RENDA:");

        System.out.printf("Imposto sobre salário: %.2f \n", impsalario);
        System.out.printf("Imposto sobre serviços: %.2f \n", impservico);
        System.out.printf("Imposto sobre ganho de capital: %.2f \n", impcapital);

        System.out.println("DEDUÇÕES:");

        System.out.printf("Máximo dedutível: %.2f \n", maxded);
        System.out.printf("Gastos dedutíveis: %.2f \n", gastosded);

        System.out.println("RESUMO:");

        System.out.printf("Imposto bruto total: %.2f \n", impbruto);
        System.out.printf("Abatimento: %.2f \n", totalded);
        System.out.printf("Imposto devido: %.2f \n", impdevido);

        sc.close();
    }
}