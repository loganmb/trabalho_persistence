package br.com.fiap.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PEDIDO", catalog = "pdv", uniqueConstraints = { @UniqueConstraint(columnNames = "CODIGO_PEDIDO") })
@NamedQuery(name = "Pedido.findAll", query = "select p from Pedido p")
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "DESCRICAO")
	private String desc;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "PRODUTO", catalog = "pdv", joinColumns = 
	{ 
		@JoinColumn(name = "PRODUTO_ID", nullable = false, updatable=false) })
	private Set<Produto> produtos;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDCLIENTE")
	private Cliente cliente;

}
