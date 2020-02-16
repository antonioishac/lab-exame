package br.com.labexame.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.labexame.domain.id.PrestadorPK;

@Entity
@Table(name = "tb_prst")
public class Prestador implements Serializable {

	private static final long serialVersionUID = -8191840835248153035L;

	@EmbeddedId
	private PrestadorPK id;

	@Column(name = "ds_razo_soci")
	private String razaoSocial;

	@Column(name = "ds_nota_ctto")
	private String descricao;

	@Column(name = "dt_alte")
	private LocalDateTime dataAlteracao;

	@ManyToOne
	@JoinColumn(name = "id_user")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_oper", nullable=false, insertable=false, updatable=false)
	private Operadora operadora;

	/**
	 * @return the id
	 */
	public PrestadorPK getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(PrestadorPK id) {
		this.id = id;
	}

	/**
	 * @return the razaoSocial
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}

	/**
	 * @param razaoSocial the razaoSocial to set
	 */
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the dataAlteracao
	 */
	public LocalDateTime getDataAlteracao() {
		return dataAlteracao;
	}

	/**
	 * @param dataAlteracao the dataAlteracao to set
	 */
	public void setDataAlteracao(LocalDateTime dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the operadora
	 */
	public Operadora getOperadora() {
		return operadora;
	}

	/**
	 * @param operadora the operadora to set
	 */
	public void setOperadora(Operadora operadora) {
		this.operadora = operadora;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Prestador [id=" + id + ", razaoSocial=" + razaoSocial + ", descricao=" + descricao + ", dataAlteracao="
				+ dataAlteracao + ", usuario=" + usuario + ", operadora=" + operadora + "]";
	}
}
