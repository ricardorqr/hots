package br.com.hots.modelo.jogo;

// Generated 22/08/2015 22:43:50 by Hibernate Tools 4.3.1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Time generated by hbm2java
 */
@Entity
@Table(name = "time", catalog = "hots")
public class Time implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idTime;
	private Heroi heroi;
	private Jogador jogador;
	private Set<Partida> partidasForIdTime1 = new HashSet<Partida>(0);
	private Set<Partida> partidasForIdTime2 = new HashSet<Partida>(0);
	private Set<Partida> partidasForIdTimeVencedor = new HashSet<Partida>(0);

	public Time() {
	}

	public Time(Heroi heroi, Jogador jogador) {
		this.heroi = heroi;
		this.jogador = jogador;
	}

	public Time(Heroi heroi, Jogador jogador, Set<Partida> partidasForIdTime1,
			Set<Partida> partidasForIdTime2,
			Set<Partida> partidasForIdTimeVencedor) {
		this.heroi = heroi;
		this.jogador = jogador;
		this.partidasForIdTime1 = partidasForIdTime1;
		this.partidasForIdTime2 = partidasForIdTime2;
		this.partidasForIdTimeVencedor = partidasForIdTimeVencedor;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idTime", unique = true, nullable = false)
	public Integer getIdTime() {
		return this.idTime;
	}

	public void setIdTime(Integer idTime) {
		this.idTime = idTime;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idHeroi", nullable = false)
	public Heroi getHeroi() {
		return this.heroi;
	}

	public void setHeroi(Heroi heroi) {
		this.heroi = heroi;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idJogador", nullable = false)
	public Jogador getJogador() {
		return this.jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "timeByIdTime1")
	public Set<Partida> getPartidasForIdTime1() {
		return this.partidasForIdTime1;
	}

	public void setPartidasForIdTime1(Set<Partida> partidasForIdTime1) {
		this.partidasForIdTime1 = partidasForIdTime1;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "timeByIdTime2")
	public Set<Partida> getPartidasForIdTime2() {
		return this.partidasForIdTime2;
	}

	public void setPartidasForIdTime2(Set<Partida> partidasForIdTime2) {
		this.partidasForIdTime2 = partidasForIdTime2;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "timeByIdTimeVencedor")
	public Set<Partida> getPartidasForIdTimeVencedor() {
		return this.partidasForIdTimeVencedor;
	}

	public void setPartidasForIdTimeVencedor(
			Set<Partida> partidasForIdTimeVencedor) {
		this.partidasForIdTimeVencedor = partidasForIdTimeVencedor;
	}

}
