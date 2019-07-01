package br.com.fiap.entity;

import javax.persistence.Column; 
import javax.persistence.Entity; 
import javax.persistence.FetchType; 
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType; 
import javax.persistence.Id; 
import javax.persistence.JoinColumn; 
import javax.persistence.ManyToOne; 
import javax.persistence.Table;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private int id;

}
