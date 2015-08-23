package br.com.hots.modelo.seguranca;

// Generated 22/08/2015 22:43:50 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Transacao generated by hbm2java
 */
@Entity
@Table(name = "transacao", catalog = "hots", uniqueConstraints = @UniqueConstraint(columnNames = "deTrancacao"))
public class Transacao implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idTransacao;
	private String deTrancacao;
	private String observacao;
	private Date dataCadastro;
	private String flagAtivo;
	private Set<Perfiltransacao> perfiltransacaos = new HashSet<Perfiltransacao>(0);

	public Transacao() {
	}

	public Transacao(Integer idTransacao, String deTrancacao, Date dataCadastro,
			String flagAtivo) {
		this.idTransacao = idTransacao;
		this.deTrancacao = deTrancacao;
		this.dataCadastro = dataCadastro;
		this.flagAtivo = flagAtivo;
	}

	public Transacao(Integer idTransacao, String deTrancacao, String observacao,
			Date dataCadastro, String flagAtivo,
			Set<Perfiltransacao> perfiltransacaos) {
		this.idTransacao = idTransacao;
		this.deTrancacao = deTrancacao;
		this.observacao = observacao;
		this.dataCadastro = dataCadastro;
		this.flagAtivo = flagAtivo;
		this.perfiltransacaos = perfiltransacaos;
	}

	@Id
	@Column(name = "idTransacao", unique = true, nullable = false)
	public Integer getIdTransacao() {
		return this.idTransacao;
	}

	public void setIdTransacao(Integer idTransacao) {
		this.idTransacao = idTransacao;
	}

	@Column(name = "deTrancacao", unique = true, nullable = false, length = 100)
	public String getDeTrancacao() {
		return this.deTrancacao;
	}

	public void setDeTrancacao(String deTrancacao) {
		this.deTrancacao = deTrancacao;
	}

	@Column(name = "observacao", length = 500)
	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataCadastro", nullable = false, length = 19)
	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Column(name = "flagAtivo", nullable = false, length = 1)
	public String getFlagAtivo() {
		return this.flagAtivo;
	}

	public void setFlagAtivo(String flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transacao")
	public Set<Perfiltransacao> getPerfiltransacaos() {
		return this.perfiltransacaos;
	}

	public void setPerfiltransacaos(Set<Perfiltransacao> perfiltransacaos) {
		this.perfiltransacaos = perfiltransacaos;
	}

}
