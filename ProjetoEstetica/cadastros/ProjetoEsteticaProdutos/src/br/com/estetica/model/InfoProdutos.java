package br.com.estetica.model;

public class InfoProdutos {
	String produto, tipoProduto, descontaComissao;
	double custo, precoVenda, descontoMax, descontoPromo;
	int comissao;
	ValidarNum numero = new ValidarNum();
	
	
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getTipoProduto() {
		return tipoProduto;
	}
	public void setTipo_produto(String tipo_produto) {
		this.tipoProduto = tipo_produto;
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
	public void setCusto(String custo) {
		numero.setNumero(custo);
		this.custo = numero.getNumero();
	}
	public double getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(String precoVenda) {
		numero.setNumero(precoVenda);
		this.precoVenda = numero.getNumero();
	}
	public double getDescontoMax() {
		return descontoMax;
	}
	public void setDescontoMax(String descontoMax) {
		numero.setNumero(descontoMax);
		this.descontoMax = numero.getNumero();
	}
	public double getDescontoPromo() {
		return descontoPromo;
	}
	public void setDescontoPromo(String descontoPromo) {
		numero.setNumero(descontoPromo);
		this.descontoPromo = numero.getNumero();
	}
	public int getComissao() {
		return comissao;
	}
	public void setComissao(int comissao) {
		this.comissao = comissao;
	}
	
	
}
