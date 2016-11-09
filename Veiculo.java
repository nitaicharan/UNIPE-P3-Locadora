package locadora;

public class Veiculo {
	private boolean tipoVeiculo = true; // True = carro		False = moto
	private double valorDiaria;
	private String descricaoVeiculo;
	private String placaVeiculo;
	private int carroNumeroPassageiros;
	private boolean motoPartidaEletrica = true; // True = tem partida		False = não tem partida
	private boolean disponivel = true; // True = disponivel			False = não disponivel

	/**
	* Returns value of tipoVeiculo
	* @return
	*/
	public boolean isTipoVeiculo() {
		return tipoVeiculo;
	}
	/**
	* Sets new value of tipoVeiculo
	* @param
	*/
	public void setTipoVeiculo(boolean tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	/**
	* Returns value of valorDiaria
	* @return
	*/
	public double getValorDiaria() {
		return valorDiaria;
	}
	/**
	* Sets new value of valorDiaria
	* @param
	*/
	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	/**
	* Returns value of descricaoVeiculo
	* @return
	*/
	public String getDescricaoVeiculo() {
		return descricaoVeiculo;
	}
	/**
	* Sets new value of descricaoVeiculo
	* @param
	*/
	public void setDescricaoVeiculo(String descricaoVeiculo) {
		this.descricaoVeiculo = descricaoVeiculo;
	}

	/**
	* Returns value of placaVeiculo
	* @return
	*/
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}
	/**
	* Sets new value of placaVeiculo
	* @param
	*/
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	/**
	* Returns value of carroNumeroPassageiros
	* @return
	*/
	public int getCarroNumeroPassageiros() {
		return carroNumeroPassageiros;
	}
	/**
	* Sets new value of carroNumeroPassageiros
	* @param
	*/
	public void setCarroNumeroPassageiros(int carroNumeroPassageiros) {
		this.carroNumeroPassageiros = carroNumeroPassageiros;
	}

	/**
	* Returns value of motoPartidaEletrica
	* @return
	*/
	public boolean isMotoPartidaEletrica() {
		return motoPartidaEletrica;
	}
	/**
	* Sets new value of motoPartidaEletrica
	* @param
	*/
	public void setMotoPartidaEletrica(boolean motoPartidaEletrica) {
		this.motoPartidaEletrica = motoPartidaEletrica;
	}

	/**
	* Returns value of disponivel
	* @return
	*/
	public boolean isDisponivel() {
		return disponivel;
	}
	/**
	* Sets new value of disponivel
	* @param
	*/
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
}
