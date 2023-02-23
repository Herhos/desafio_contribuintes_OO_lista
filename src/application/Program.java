package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program
{
	// DESAFIO CONTRIBUINTES OO E LISTA
	
	public static void main(String[] args)
	{
		Locale.setDefault(Locale.US);
		
		double salario, servico, capital, medico, educacao;
		
		try (Scanner sc = new Scanner(System.in))
		{
			List<TaxPayer> list = new ArrayList<>();
			
			System.out.print("Quantos contribuinte você vai digitar? ");
			int n = sc.nextInt();			
			
			System.out.println();
			for (int i = 0; i < n; i++)
			{
				System.out.println("Digite os dados do " + (i + 1) + "° contribuinte:");
				System.out.print("Renda anual com salário: ");
				salario = sc.nextDouble();
				System.out.print("Renda anual com prestação de serviço: ");
				servico = sc.nextDouble();
				System.out.print("Renda anual com ganho de capital: ");
				capital = sc.nextDouble();
				System.out.print("Gastos médicos: ");
				medico = sc.nextDouble();
				System.out.print("Gastos educacionais: ");
				educacao = sc.nextDouble();
				System.out.println();
				list.add(new TaxPayer(salario, servico, capital, medico, educacao));
			}						
			
			int i = 0;
			for (TaxPayer payer : list)
			{				
				System.out.println("Resumo do " + (i + 1) + "° contribuinte:");
				System.out.printf("Imposto bruto total: %.2f \n",  payer.grossTax());
				System.out.printf("Abatimento: %.2f \n", payer.taxRebate());
				System.out.printf("Imposto devido: %.2f \n", payer.netTax());
				System.out.println();
				i++;
			}			
			sc.close();
		}
	}
}
