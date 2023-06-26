package br.com.estetica.model;

public class InfoProdutos {
	String produto, tipo_produto, descontaComissao;
	double custo, precoVenda, descontoMax, descontoPromo;
	int comissao;
	
	
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getTipoProduto() {
		return tipo_produto;
	}
	public void setTipo_produto(String tipo_produto) {
		this.tipo_produto = tipo_produto;
	}
	public String getDescontaComissao() {
		return descontaComissao;
	}
	public void setDescontaComissao(String descontaComissao) {
		this.descontaComissao = descontaComissao;
	}
	public double getCusto() {
		return custo;
	}
	public void setCusto(double custo) {
		this.custo = custo;
	}
	public double getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}
	public double getDescontoMax() {
		return descontoMax;
	}
	public void setDescontoMax(double descontoMax) {
		this.descontoMax = descontoMax;
	}
	public double getDescontoPromo() {
		return descontoPromo;
	}
	public void setDescontoPromo(double descontoPromo) {
		this.descontoPromo = descontoPromo;
	}
	public int getComissao() {
		return comissao;
	}
	public void setComissao(int comissao) {
		this.comissao = comissao;
	}
	
	
}
