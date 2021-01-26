package br.com.guilherme.jpa.modelo;

public class MediaComData {
	private double valor;
	private Integer dia;

	public MediaComData(double valor, Integer dia, Integer mes) {
		this.valor = valor;
		this.dia = dia;
		this.mes = mes;
	}

	private Integer mes;

	public double getValor() {
		return valor;
	}

	public Integer getDia() {
		return dia;
	}

	public Integer getMes() {
		return mes;
	}
}
