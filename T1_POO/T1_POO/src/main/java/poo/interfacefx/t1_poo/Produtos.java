package poo.interfacefx.t1_poo;

public class Produtos {
    private String nome,descricao , marca , categoria;
    private Double preco, custo;

    public Produtos() {
       this("","","","",0,0);
    }

    public Produtos(String nome, String descricao, String marca, String categoria,
                    double preco,double custo){
        this.nome = nome;
        this.descricao = descricao;
        this.marca = marca;
        this.categoria = categoria;
        this.preco = preco;
        this.custo = custo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }
}
