package br.com.labexame.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author aishac
 *
 * Entidade que representa a tabela de endere\u00e7os, TB_ENDERECO
 *
 */

@Entity
@Table(name = "TB_ENDERECO")
public class Endereco implements Serializable {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -4962385074705460536L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@NotBlank(message = "labexame-end-log")
	@Column(name = "LOGRADOURO")
	private String logradouro;

	@NotBlank(message = "labexame-end-num")
	@Column(name = "NUMERO")
	private String numero;

	@NotBlank(message = "labexame-end-cep")
	@Column(name = "CEP")
	private String cep;

	@NotBlank(message = "labexame-end-bai")
	@Column(name = "BAIRRO")
	private String bairro;

	@NotBlank(message = "labexame-end-cid")
	@Column(name = "CIDADE")
	private String cidade;

	@NotBlank(message = "labexame-end-uf")
	@Column(name = "UF")
	private String uf;

	@NotBlank(message = "labexame-end-ddd")
	@Column(name = "DDD")
	private String ddd;

	@NotBlank(message = "labexame-end-fon")
	@Column(name = "telefone")
	private String telefone;

	@JsonIgnoreProperties("laboratorio")
	@OneToOne
	@JoinColumn(referencedColumnName="ID", name="ID_LABORATORIO")
	private Laboratorio laboratorio;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @param logradouro the logradouro to set
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return the uf
	 */
	public String getUf() {
		return uf;
	}

	/**
	 * @param uf the uf to set
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}

	/**
	 * @return the ddd
	 */
	public String getDdd() {
		return ddd;
	}

	/**
	 * @param ddd the ddd to set
	 */
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the laboratorio
	 */
	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	/**
	 * @param laboratorio the laboratorio to set
	 */
	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", logradouro=" + logradouro + ", numero=" + numero + ", cep=" + cep + ", bairro="
				+ bairro + ", cidade=" + cidade + ", uf=" + uf + ", ddd=" + ddd + ", telefone=" + telefone
				+ ", laboratorio=" + laboratorio + "]";
	}
}
