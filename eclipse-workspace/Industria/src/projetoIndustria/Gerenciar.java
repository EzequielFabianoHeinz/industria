package projetoIndustria;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gerenciar {

	public static void main(String[] args) {

		List<Funcionario> funcionarios = new ArrayList<>();

		insertEmploye(funcionarios);
		removeEmploye(funcionarios, "João");
		increaseSalaryEmploye(funcionarios);

		Map<String, List<Funcionario>> employeByFunction = groupByFunction(funcionarios);

		printHeader();

		for (List<Funcionario> funcionariosByFunction : employeByFunction.values()) {
			printEmploye(funcionariosByFunction);
		}

		printTotalSalary(funcionarios);
		printEmployeesSortedByName(funcionarios);
		printEmployeesByBirthdayMonth(funcionarios);
		printOldestEmployee(funcionarios);

	}

	public static void insertEmploye(List<Funcionario> funcionarios) {
		funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
		funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
		funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
		funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
		funcionarios
				.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
		funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
		funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
		funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
		funcionarios
				.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
		funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
	}

	public static void removeEmploye(List<Funcionario> funcionarios, String name) {
		funcionarios.removeIf(funcionario -> name.equals(funcionario.getName()));
	}

	public static void printHeader() {
		System.out.println(
				"+----------------------+----------------------------+----------------------+-------------------+----------------------+");
		System.out.println(
				"| name                 | Data de Nascimento         | Salário              | Função            | Quant. Salário Min.  |");
		System.out.println(
				"+----------------------+----------------------------+----------------------+-------------------+----------------------+");
	}

	public static void printEmploye(List<Funcionario> funcionarios) {
		DecimalFormat df = new DecimalFormat("###,###,###.00");

		for (Funcionario funcionario : funcionarios) {
			BigDecimal salaryInMin = medMinSalary(funcionario);

			System.out.printf("| %-20s | %-26s | %-20s | %-17s | %-20s |\n", funcionario.getName(),
					funcionario.getdtaBorn().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
					df.format(funcionario.getSalary()), funcionario.getFuncao(), df.format(salaryInMin));
		}

		System.out.println(
				"+----------------------+----------------------------+----------------------+-------------------+----------------------+");
	}

	public static void increaseSalaryEmploye(List<Funcionario> funcionarios) {
		for (Funcionario funcionario : funcionarios) {
			BigDecimal salary = funcionario.getSalary();
			BigDecimal payRaise = salary.multiply(new BigDecimal("0.10"));

			BigDecimal newSalary = salary.add(payRaise);

			funcionario.setSalary(newSalary);
		}
	}

	public static Map<String, List<Funcionario>> groupByFunction(List<Funcionario> funcionarios) {
		Map<String, List<Funcionario>> byFunctionMap = new HashMap<>();

		for (Funcionario funcionario : funcionarios) {
			String function = funcionario.getFuncao();

			if (!byFunctionMap.containsKey(function)) {
				byFunctionMap.put(function, new ArrayList<>());
			}

			byFunctionMap.get(function).add(funcionario);
		}

		return byFunctionMap;
	}

	public static void printTotalSalary(List<Funcionario> funcionarios) {
		BigDecimal totalSalary = BigDecimal.ZERO;
		for (Funcionario funcionario : funcionarios) {
			totalSalary = totalSalary.add(funcionario.getSalary());
		}
		DecimalFormat df = new DecimalFormat("###,###,###.00");
		System.out.println("\nTotal dos salários: R$ " + df.format(totalSalary) + "\n");
	}

	public static void printEmployeesSortedByName(List<Funcionario> funcionarios) {
		System.out.println("\nFuncionários por ordem Alfabética: \n");
		funcionarios.sort((f1, f2) -> f1.getName().compareTo(f2.getName()));
		printHeader();
		printEmploye(funcionarios);
	}

	public static void printEmployeesByBirthdayMonth(List<Funcionario> funcionarios) {
		System.out.println("\nFuncionários com aniversário em outubro e dezembro: \n");
		printHeader();

		List<Funcionario> aniversariantes = funcionarios.stream()
				.filter(f -> f.getdtaBorn().getMonthValue() == 10 || f.getdtaBorn().getMonthValue() == 12).toList();

		printEmploye(aniversariantes);

		System.out.println();
	}

	public static void printOldestEmployee(List<Funcionario> funcionarios) {
		Funcionario oldest = funcionarios.stream()
				.max((f1, f2) -> Integer.compare(f1.getdtaBorn().getYear(), f2.getdtaBorn().getYear())).orElse(null);

		if (oldest != null) {
			int age = LocalDate.now().getYear() - oldest.getdtaBorn().getYear();
			if (LocalDate.now().getMonthValue() < oldest.getdtaBorn().getMonthValue()
					|| (LocalDate.now().getMonthValue() == oldest.getdtaBorn().getMonthValue()
							&& LocalDate.now().getDayOfMonth() < oldest.getdtaBorn().getDayOfMonth())) {
				age--;
			}

			System.out.println("\nFuncionário com a maior idade:");
			System.out.println("name: " + oldest.getName());
			System.out.println("Idade: " + age + " anos");
		} else {
			System.out.println("Nenhum funcionário encontrado.");
		}
	}

	public static BigDecimal medMinSalary(Funcionario funcionario) {
		BigDecimal minSalary = new BigDecimal("1212.00");
		return funcionario.getSalary().divide(minSalary, 2, RoundingMode.HALF_UP);
	}

}