package com.company;

import java.util.Scanner;

public class ValorAngulo
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		// Usuário precisa inserir o valor em minutos

		System.out.print("Informe o valor dos minutos: ");

		int h = 60;
		int min = scanner.nextInt();

		// Verificação para o usuário não inserir um valor inválido
		if (min < 0 || min > 59)
		{
			System.out.println("O valor informado é inválido.");
			return;
		}

		double ValorAngulo = (min * 360) / h;

		//Validação pra ver se o algulo não é maior que 180
		//pois nesses casos precisamos pegar o valor obtido e diminuir por 360
		if (ValorAngulo < 180)
		{

			System.out.println("O valor do ângulo é: " + ValorAngulo);
		}
		else
		{
			ValorAngulo = 360 - ValorAngulo;
			System.out.println(" O valor do ângulo é: " + ValorAngulo);

		}

		scanner.close();

	}
}
