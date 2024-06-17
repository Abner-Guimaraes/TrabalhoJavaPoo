package poo.interfacefx.t1_poo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.util.stream.Collectors;
import java.util.List;

import poo.interfacefx.t1_poo.connection.ConexaoDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProdutosControlador {
    private final ObservableList<Produtos> produtos;

    public ProdutosControlador() {
        this.produtos = FXCollections.observableArrayList();
        getProdutos();
    }

    private void carregarProdutosIniciais() {
//        for (int i = 0; i < 10; i++) {
//            produtos.add(new Produtos("Televisão", "Lorem ipsum",
//                    "Samsung", "Eletrodomésticos", 1200.00,
//                    500.00));
//            produtos.add(new Produtos("Play Station 5", "Lorem ipsum", "Sony",
//                    "Eletrodomésticossssssssssssssssssssssssssssssssssssssssssssss",
//                    5000.00, 2500.00));
//        }
    }

    public ObservableList<Produtos> getProdutos() {
        String sql = "SELECT * FROM produtos_table";
        produtos.clear();
        PreparedStatement ps;
        ResultSet db_result;
        try{
            ps = ConexaoDB.getConn().prepareStatement(sql);
            db_result = ps.executeQuery();

            while(db_result.next()){
                Produtos p = new Produtos();

                p.setId(db_result.getInt("id"));
                p.setNome(db_result.getString("name"));
                p.setDescricao(db_result.getString("short_description"));
                p.setMarca(db_result.getString("brand"));
                p.setCategoria(db_result.getString("category"));
                p.setPreco(db_result.getDouble("list_price"));
                p.setCusto(db_result.getDouble("cost"));

                produtos.add(p);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }


        return produtos;
    }

    public int getQuantidadeDeProdutos() {
        return produtos.size();
    }

    public void criarProduto(TextField nomeInput, TextField descricaoInput,
                             TextField marcaInput, TextField categoriaInput,
                             TextField precoInput, TextField custoInput,
                             TableView<Produtos> tabela) {

            String sql = "INSERT INTO produtos_table(name, short_description, brand, category, list_price, cost)"+
                    "VALUES(?,?,?,?,?,?)";

            Produtos p = new Produtos();

            p.setNome(nomeInput.getText());
            p.setDescricao(descricaoInput.getText());
            p.setMarca(marcaInput.getText());
            p.setCategoria(categoriaInput.getText());
            p.setPreco(Double.parseDouble(precoInput.getText()));
            p.setCusto(Double.parseDouble(custoInput.getText()));

            PreparedStatement ps;

            try{
                ps = ConexaoDB.getConn().prepareStatement(sql);
                ps.setString(1,p.getNome());
                ps.setString(2,p.getDescricao());
                ps.setString(3,p.getMarca());
                ps.setString(4,p.getCategoria());
                ps.setDouble(5, p.getPreco());
                ps.setDouble(6, p.getCusto());

                ps.execute();
                ps.close();
                getProdutos();
            }catch (SQLException e){
                e.printStackTrace();
            }








    }

    public void atualizarProduto(boolean flag, Produtos p, String novoNome,
                                 String novaDescricao, String novaMarca,
                                 String novaCategoria, double novoPreco,
                                 double novoCusto, TableView<Produtos> tabela) {

        if(flag){
            String sql = "UPDATE produtos_table SET name = ?, short_description = ?, brand = ?, category = ?, list_price = ?, cost = ?  WHERE id = ?";
            PreparedStatement ps;
            try{
                ps = ConexaoDB.getConn().prepareStatement(sql);
                ps.setString(1,novoNome);
                ps.setString(2,novaDescricao);
                ps.setString(3,novaMarca);
                ps.setString(4,novaCategoria);
                ps.setDouble(5, novoPreco);
                ps.setDouble(6, novoCusto);
                ps.setInt(7, p.getId());
                ps.execute();
                ps.close();
                getProdutos();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void deletarProduto(boolean flag, Produtos produto, TableView<Produtos> tabela) {
        if(flag){

            String sql = ("DELETE FROM produtos_table WHERE id = " + produto.getId());

            PreparedStatement ps;
            try{
                ps = ConexaoDB.getConn().prepareStatement(sql);
                ps.execute();
                ps.close();
                getProdutos();
            }catch (SQLException e){
               e.printStackTrace();
            }
        }
    }

    public ObservableList<Produtos> filtrarProdutos(String criterio) {
        if (criterio == null || criterio.isEmpty()) {
            return getProdutos();
        }
        String sql = "SELECT * FROM produtos_table WHERE name LIKE ?";

        produtos.clear();
        criterio = (criterio + '%');
        PreparedStatement ps;
        ResultSet db_result;
        try{
            ps = ConexaoDB.getConn().prepareStatement(sql);
            ps.setString(1,criterio);
            db_result = ps.executeQuery();

            while(db_result.next()){
                Produtos p = new Produtos();

                p.setId(db_result.getInt("id"));
                p.setNome(db_result.getString("name"));
                p.setDescricao(db_result.getString("short_description"));
                p.setMarca(db_result.getString("brand"));
                p.setCategoria(db_result.getString("category"));
                p.setPreco(db_result.getDouble("list_price"));
                p.setCusto(db_result.getDouble("cost"));

                produtos.add(p);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }


        return produtos;
    }

}

