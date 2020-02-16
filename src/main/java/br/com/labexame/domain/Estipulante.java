package br.com.labexame.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.labexame.domain.id.EstipulantePK;

@Entity
@Table(name = "tb_opr_estp")
public class Estipulante implements Serializable {

	private static final long serialVersionUID = 6111091216745682266L;

	@EmbeddedId
	private EstipulantePK id;

    @Column(name = "nm_estp")
    private String nomeEstipulante;

    @Column(name = "fl_atvo")
    private String flagAtivo;

    @Column(name = "dt_alte")
    private LocalDateTime dataAlteracao;

    @ManyToOne
    @JoinColumn(name = "id_oper", nullable=false, insertable=false, updatable=false)
    private Operadora operadora;

	/**
	 * @return the id
	 */
	public EstipulantePK getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(EstipulantePK id) {
		this.id = id;
	}

	/**
	 * @return the nomeEstipulante
	 */
	public String getNomeEstipulante() {
		return nomeEstipulante;
	}

	/**
	 * @param nomeEstipulante the nomeEstipulante to set
	 */
	public void setNomeEstipulante(String nomeEstipulante) {
		this.nomeEstipulante = nomeEstipulante;
	}

	/**
	 * @return the flagAtivo
	 */
	public String getFlagAtivo() {
		return flagAtivo;
	}

	/**
	 * @param flagAtivo the flagAtivo to set
	 */
	public void setFlagAtivo(String flagAtivo) {
		this.flagAtivo = flagAtivo;
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
		return "Estipulante [id=" + id + ", nomeEstipulante=" + nomeEstipulante + ", flagAtivo=" + flagAtivo
				+ ", dataAlteracao=" + dataAlteracao + ", operadora=" + operadora + "]";
	}
}
