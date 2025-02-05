package projetoIndustria;

import java.time.LocalDate;

public class Pessoa {

	private String name;
	private LocalDate dtaBorn;

	public Pessoa(String name, LocalDate dtaBorn) {
		this.name = name;
		this.dtaBorn = dtaBorn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getdtaBorn() {
		return dtaBorn;
	}

	public void setdtaBorn(LocalDate dtaBorn) {
		this.dtaBorn = dtaBorn;
	}
}