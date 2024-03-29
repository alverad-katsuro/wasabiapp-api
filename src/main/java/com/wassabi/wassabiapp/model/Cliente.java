package com.wassabi.wassabiapp.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Cliente generated by hbm2java
 */
@Entity
@Table(name = "Cliente", catalog = "wassabi")
public class Cliente implements java.io.Serializable {

	private Integer clienteId;
	private String clienteNome;
	private String clienteSobrenome;
	private String clienteCpf;
	private String clienteTelefone;
    @JsonIgnore
	private Set<Venda> vendas = new HashSet<Venda>(0);
	private Set<Cartao> cartaos = new HashSet<Cartao>(0);
    @JsonIgnore
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);
	private Set<Endereco> enderecos = new HashSet<Endereco>(0);

	public Cliente() {
	}

	public Cliente(String clienteNome, String clienteSobrenome, String clienteCpf, String clienteTelefone) {
		this.clienteNome = clienteNome;
		this.clienteSobrenome = clienteSobrenome;
		this.clienteCpf = clienteCpf;
		this.clienteTelefone = clienteTelefone;
	}

	public Cliente(String clienteNome, String clienteSobrenome, String clienteCpf, String clienteTelefone,
			Set<Venda> vendas, Set<Cartao> cartaos, Set<Endereco> enderecos) {
		this.clienteNome = clienteNome;
		this.clienteSobrenome = clienteSobrenome;
		this.clienteCpf = clienteCpf;
		this.clienteTelefone = clienteTelefone;
		this.vendas = vendas;
		this.cartaos = cartaos;
		this.enderecos = enderecos;
	}

	
    /** 
     * @return Integer
     */
    @Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cliente_id", unique = true, nullable = false)
	public Integer getClienteId() {
		return this.clienteId;
	}

	
    /** 
     * @param clienteId
     */
    public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	
    /** 
     * @return String
     */
    @Column(name = "cliente_nome", nullable = false, length = 30)
	public String getClienteNome() {
		return this.clienteNome;
	}

	
    /** 
     * @param clienteNome
     */
    public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}

	
    /** 
     * @return String
     */
    @Column(name = "cliente_sobrenome", nullable = false, length = 60)
	public String getClienteSobrenome() {
		return this.clienteSobrenome;
	}

	
    /** 
     * @param clienteSobrenome
     */
    public void setClienteSobrenome(String clienteSobrenome) {
		this.clienteSobrenome = clienteSobrenome;
	}

	
    /** 
     * @return String
     */
    @Column(name = "cliente_cpf", nullable = false, length = 14)
	public String getClienteCpf() {
		return this.clienteCpf;
	}

	
    /** 
     * @param clienteCpf
     */
    public void setClienteCpf(String clienteCpf) {
		this.clienteCpf = clienteCpf;
	}

	
    /** 
     * @return String
     */
    @Column(name = "cliente_telefone", nullable = false, length = 15)
	public String getClienteTelefone() {
		return this.clienteTelefone;
	}

	
    /** 
     * @param clienteTelefone
     */
    public void setClienteTelefone(String clienteTelefone) {
		this.clienteTelefone = clienteTelefone;
	}

	
    /** 
     * @return Set<Venda>
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<Venda> getVendas() {
		return this.vendas;
	}

	
    /** 
     * @param vendas
     */
    public void setVendas(Set<Venda> vendas) {
		this.vendas = vendas;
	}

	
    /** 
     * @return Set<Cartao>
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = {CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
	public Set<Cartao> getCartaos() {
		return this.cartaos;
	}

	
    /** 
     * @param cartaos
     */
    public void setCartaos(Set<Cartao> cartaos) {
		this.cartaos = cartaos;
	}


    
    /** 
     * @return Set<Usuario>
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", orphanRemoval = true)
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	
    /** 
     * @param usuarios
     */
    public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	
    /** 
     * @return Set<Endereco>
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = {CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
	public Set<Endereco> getEnderecos() {
		return this.enderecos;
	}

	
    /** 
     * @param enderecos
     */
    public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Cliente [clienteId=" + clienteId + ", clienteNome=" + clienteNome + ", clienteSobrenome="
                + clienteSobrenome + ", clienteCpf=" + clienteCpf + ", clienteTelefone=" + clienteTelefone + "]";
    }

    @Transient
    public String getClienteNomeCompleto(){
        return (String.format("%s %s", this.clienteNome, this.clienteSobrenome));
    }


    @Transient
    public void addEndereco(Endereco endereco){
        endereco.setId(new EnderecoId());
        endereco.getId().setEnderecoCliente(this.getClienteId());
        this.enderecos.add(endereco);
    }

    @Transient
    public void addEndereco(Set<Endereco> enderecos){
        for (Endereco endereco : enderecos) {
            endereco.setId(new EnderecoId());
            endereco.getId().setEnderecoCliente(this.getClienteId());
            this.enderecos.add(endereco);
        }
    }

    @Transient
    public void addCartao(Cartao cartao){
        cartao.setId(new CartaoId());
        cartao.getId().setCartaoCliente(this.getClienteId());
        this.cartaos.add(cartao);
    }

    @Transient
    public void addCartao(Set<Cartao> cartoes){
        for (Cartao cartao : cartoes) {
            cartao.setId(new CartaoId());
            cartao.getId().setCartaoCliente(this.getClienteId());
            this.cartaos.add(cartao);
        }
    }

    /*
     * Esta função tem como objetivo ser uma rotina interna do ClienteDAO.create pois a ID do Endereco não está atualizando.
     */
    public void updateEnderecoID(){
        if (this.enderecos.size() > 0) {
            this.enderecos.forEach(endereco -> {
                endereco.setId(new EnderecoId());
                endereco.getId().setEnderecoCliente(this.getClienteId());
            });    
        }
    }

    /*
     * Esta função tem como objetivo ser uma rotina interna do ClienteDAO.create pois a ID do Endereco não está atualizando.
     */
    public void updateCartaoID(){
        if (this.cartaos.size() > 0) {
            this.cartaos.forEach(cartao -> {
                cartao.getId().setCartaoCliente(this.clienteId);
            });
        }
    }
}
