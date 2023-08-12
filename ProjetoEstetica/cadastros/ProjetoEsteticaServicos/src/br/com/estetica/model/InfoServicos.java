package br.com.estetica.model;



public class InfoServicos {
	private String nomeServico, categoria, tipoServico, comissao, observacao;
	private float custoProd, precoVenda;
	private int descontoMax, descontoPromo, duracaoAprox, percentual, descontarProdutos;
	public String getNomeServico() {
		return nomeServico;
	}
	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getTipoServico() {
		return tipoServico;
	}
	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}
	public String getComissao() {
		return comissao;
	}
	public void setComissao(String comissao) {
		this.comissao = comissao;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public float getCustoProd() {
		return custoProd;
	}
	public void setCustoProd(float custoProd) {
		this.custoProd = custoProd;
	}
	public float getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(float precoVenda) {
		this.precoVenda = precoVenda;
	}
	public int getDescontoMax() {
		return descontoMax;
	}
	public void setDescontoMax(int descontoMax) {
		this.descontoMax = descontoMax;
	}
	public int getDescontoPromo() {
		return descontoPromo;
	}
	public void setDescontoPromo(int descontoPromo) {
		this.descontoPromo = descontoPromo;
	}
	public int getDuracaoAprox() {
		return duracaoAprox;
	}
	public void setDuracaoAprox(int duracaoAprox) {
		this.duracaoAprox = duracaoAprox;
	}
	public int getPercentual() {
		return percentual;
	}
	public void setPercentual(int percentual) {
		this.percentual = percentual;
	}
	public int getDescontarProdutos() {
		return descontarProdutos;
	}
	public void setDescontarProdutos(int descontarProdutos) {
		this.descontarProdutos = descontarProdutos;
	}


}
