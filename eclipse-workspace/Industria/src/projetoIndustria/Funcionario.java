package projetoIndustria;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa {

	private BigDecimal salary;
	private String funcao;

	public Funcionario(String name, LocalDate dtaBorn, BigDecimal salary, String funcao) {
		super(name, dtaBorn);
		this.salary = salary;
		this.funcao = funcao;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	@Override
	public String toString() {
		DateTimeFormatter dtaNascFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormat numberFormat = new DecimalFormat("#,##0.00");

		return String.format("| %-19s | %-26s | %-19s | %-26s |", getName(), getdtaBorn().format(dtaNascFormat),
				numberFormat.format(salary), funcao);
	}
}