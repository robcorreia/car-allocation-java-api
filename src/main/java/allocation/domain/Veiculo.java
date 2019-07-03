package allocation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "veiculos")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idVeiculo")
	private Long idVeiculo;

	@Column(name = "marca", nullable = false)
	@NotBlank(message="A Marca é brigatória!")
	private String marca;


	@Column(name = "modelo", nullable = false)
	@NotBlank(message="O Modelo é obrigatório!")
	private String modelo;
	
	
	@Column(name = "anoModelo", nullable = false)
	@Min(message="O ano do Modelo deve ser acima de 2010", value=2010)
	@NotNull(message="O ano do mMdelo é obrigatório!")
	private int anoModelo;
	
	@Column(name = "cor", nullable = false)
	@NotBlank(message="A Cor é obrigatória!")
	private String cor;
	
	@Column(name = "placa", nullable = false, unique=true)
	@NotBlank(message="A Placa é obrigatória!")
	@Size(max=7, message="O e-mail deve conter no máximo 7 caracteres!", min=0)
	private String placa;
	
	@Column(name = "km", nullable = false)
	@NotNull(message="A quantidade de KM é obrigatório!")
	private int km;
	
	@Column(name = "tipoCombustivel", nullable = false)
	@NotBlank(message="O tipo de combustivel é obrigatório!")
	private String tipoCombustivel;
	
	@Column(name = "valorDiaria", nullable = false)
	@NotNull(message="O valor da diária é obrigatório!")
	private float valorDiaria;
	
	@Column(name = "tipoVeiculo", nullable = false)
	@NotBlank(message="O tipo de Veículo é obrigatório!")
	private String tipoVeiculo;
	

	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public String getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public float getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(float valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public String getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	

}
